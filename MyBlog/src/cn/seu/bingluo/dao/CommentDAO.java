package cn.seu.bingluo.dao;

import java.util.List;

import cn.seu.bingluo.entity.Comment;
import cn.seu.bingluo.entity.CommentPojo;

public interface CommentDAO {
	/**
	 * 根据文章ID和rank获取文章的评论
	 * 
	 * @param id
	 * @return
	 */
	List<CommentPojo> selectCommentsByBlogIdAndBaseAndRank(long id, int base,
			int range);

	/**
	 * 根据被评论的评论ID获取子级评论
	 * 
	 * @param id
	 * @return
	 */
	List<CommentPojo> selectCommentsByCommentedId(long id);

	/**
	 * 插入评论
	 * 
	 * @param comment
	 */
	void insertComment(Comment comment);

	/**
	 * 删除评论
	 * 
	 * @param id
	 */
	void deleteComment(long id);

	/**
	 * 获取最新评论
	 * 
	 * @return
	 */
	List<CommentPojo> selectLatestComment();
}
