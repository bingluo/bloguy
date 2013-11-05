package cn.seu.bingluo.entity;

import java.util.List;

public class CommentPojo extends Comment {
	private String userName;
	private User user;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	// 子级评论
	private List<CommentPojo> commentList;

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the commentList
	 */
	public List<CommentPojo> getCommentList() {
		return commentList;
	}

	/**
	 * @param commentList
	 *            the commentList to set
	 */
	public void setCommentList(List<CommentPojo> commentList) {
		this.commentList = commentList;
	}
}
