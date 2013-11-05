package cn.seu.bingluo.entity;

import java.util.Date;

public class Comment {
	// 评论ID
	private long commentId;
	// 评论作者ID
	private Long commentUserId;
	// 评论内容
	private String content;
	// 被评论的博文Id
	private long blogId;
	// 被评论的类型
	private String toType;
	// 被评论的ID
	private long toId;
	// 评论发表时间
	private Date postTime;

	/**
	 * @return the commentId
	 */
	public long getCommentId() {
		return commentId;
	}

	/**
	 * @param commentId
	 *            the commentId to set
	 */
	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	/**
	 * @return the commentUserId
	 */
	public Long getCommentUserId() {
		return commentUserId;
	}

	/**
	 * @param commentUserId
	 *            the commentUserId to set
	 */
	public void setCommentUserId(Long commentUserId) {
		this.commentUserId = commentUserId;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the blogId
	 */
	public long getBlogId() {
		return blogId;
	}

	/**
	 * @param blogId
	 *            the blogId to set
	 */
	public void setBlogId(long blogId) {
		this.blogId = blogId;
	}

	/**
	 * @return the toType
	 */
	public String getToType() {
		return toType;
	}

	/**
	 * @param toType
	 *            the toType to set
	 */
	public void setToType(String toType) {
		this.toType = toType;
	}

	/**
	 * @return the toId
	 */
	public long getToId() {
		return toId;
	}

	/**
	 * @param toId
	 *            the toId to set
	 */
	public void setToId(long toId) {
		this.toId = toId;
	}

	/**
	 * @return the postTime
	 */
	public Date getPostTime() {
		return postTime;
	}

	/**
	 * @param postTime
	 *            the postTime to set
	 */
	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
}
