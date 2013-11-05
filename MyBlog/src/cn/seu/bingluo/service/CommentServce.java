package cn.seu.bingluo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.seu.bingluo.dao.CommentDAOImpl;
import cn.seu.bingluo.dao.UserDAOImpl;
import cn.seu.bingluo.entity.Comment;
import cn.seu.bingluo.entity.CommentPojo;
import cn.seu.bingluo.entity.User;
import cn.seu.bingluo.view.util.ViewUtil;

@Service
public class CommentServce {
	@Autowired
	private CommentDAOImpl commentDAOImpl;
	@Autowired
	private UserDAOImpl userDAOImpl;

	public List<CommentPojo> getLatestComments() {
		List<CommentPojo> comments = commentDAOImpl.selectLatestComment();
		return comments;

	}

	public List<CommentPojo> getCommentsByBlogIdAndPageAndRange(long blogId,
			int pageNum, int range) {
		List<CommentPojo> comments = commentDAOImpl
				.selectCommentsByBlogIdAndBaseAndRank(blogId, pageNum * range,
						range);
		comments = setUsersForCommentList(comments);
		return comments;

	}

	public List<CommentPojo> getCommentsByCommentedId(long id) {
		List<CommentPojo> comments = commentDAOImpl
				.selectCommentsByCommentedId(id);
		comments = setUsersForCommentList(comments);
		return comments;
	}

	private List<CommentPojo> setUsersForCommentList(List<CommentPojo> comments) {
		for (CommentPojo commentPojo : comments) {
			User author = userDAOImpl.selectUserById(commentPojo
					.getCommentUserId());
			commentPojo.setUser(author);
		}
		return comments;
	}

	public void addComment(Comment comment) {
		commentDAOImpl.insertComment(comment);
	}

	/**
	 * 递归获取子级评论
	 * 
	 * @param comment
	 */
	public void setChildrenCommentForList(List<CommentPojo> list) {
		for (CommentPojo comment : list) {
			List<CommentPojo> children = getCommentsByCommentedId(comment
					.getCommentId());
			comment.setCommentList(children);
			for (CommentPojo child : children) {
				setChildrenComment(child);
			}
		}
	}

	/**
	 * 递归获取子级评论
	 * 
	 * @param comment
	 */
	private void setChildrenComment(CommentPojo comment) {
		List<CommentPojo> children = getCommentsByCommentedId(comment
				.getCommentId());
		comment.setCommentList(children);
		for (CommentPojo child : children) {
			setChildrenComment(child);
		}
	}

	private String toHtmlchildren(int depth, CommentPojo comment) {
		StringBuilder html = new StringBuilder();
		html.append("<li class='depth-")
				// .append(depth)
				.append("' id='")
				.append(comment.getCommentId())
				.append("'><div class='comment-info'><img alt='' src='/static/images/avatars/")
				.append(comment.getUser().getAvatarUrl())
				.append("' class='avatar' height='40' width='40' /><cite><a class='commentAuthor' href='#'>")
				.append(comment.getUserName())
				.append("</a> 发表于:<span class='comment-data'>")
				.append(ViewUtil.timeFormat1(comment.getPostTime()))
				.append("</span><span class='comment-text'><p>")
				.append(comment.getContent())
				.append("</p></span></cite></div>")
				.append("<div class='comment-text'></p><div class='reply'><a rel='nofollow' class='comment-reply-link' href='#replyForm'>回复</a></div></div>");

		if (comment.getCommentList() != null
				&& comment.getCommentList().size() > 0) {
			html.append("<ul class='children'>");
			for (CommentPojo commentPojo : comment.getCommentList()) {
				html.append(toHtmlchildren(depth + 1, commentPojo));// 子节点depth从depth+1开始
			}
			html.append("</ul>");
		}
		html.append("</li>");

		return html.toString();
	}

	private String toHtmlFather(int index, CommentPojo comment) {
		StringBuilder html = new StringBuilder();
		html.append("<li class='depth-1' id='")
				.append(comment.getCommentId())
				.append("'><div class='comment-info'><img alt='' src='/static/images/avatars/")
				.append(comment.getUser().getAvatarUrl())
				.append("' class='avatar' height='40' width='40' /><cite><span>")
				.append(index)
				.append("楼</span> <a class='commentAuthor' href='#'>")
				.append(comment.getUserName())
				.append("</a> 发表于:<span class='comment-data'>")
				.append(ViewUtil.timeFormat1(comment.getPostTime()))
				.append("</span><span class='comment-text'><p>")
				.append(comment.getContent())
				.append("</p></span></cite></div>")
				.append("<div class='comment-text'></p><div class='reply'><a rel='nofollow' class='comment-reply-link' href='#replyForm'>回复</a></div></div>");

		if (comment.getCommentList() != null
				&& comment.getCommentList().size() > 0) {
			html.append("<ul class='children'>");
			for (CommentPojo commentPojo : comment.getCommentList()) {
				html.append(toHtmlchildren(2, commentPojo));// 子节点depth从2开始
			}
			html.append("</ul>");
		}
		html.append("</li>");

		return html.toString();
	}

	public String toHtml(List<CommentPojo> list) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			CommentPojo commentPojo = list.get(i);
			sb.append(toHtmlFather(i + 1, commentPojo));
		}
		return sb.toString();
	}
}
