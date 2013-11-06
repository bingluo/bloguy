package cn.seu.bingluo.entity;

import java.util.Date;

public class Blog {
	// 博客ID
	private int blogId;
	// 标题
	private String title;
	// 内容
	private String content;
	// 上传日期
	private Date postTime;
	// 作者ID
	private int authorId;
	// 博客tags
	private String tags = "";
	// 文章属于哪个文件夹（归档）
	private int folderId;
	// 评论量
	private int commentCount;
	// 浏览量
	private int clickTimes;
	// 更新时间
	private Date updateTime;

	/**
	 * @return the blogId
	 */
	public int getBlogId() {
		return blogId;
	}

	/**
	 * @param blogId
	 *            the blogId to set
	 */
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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

	/**
	 * @return the authorId
	 */
	public int getAuthorId() {
		return authorId;
	}

	/**
	 * @param authorId
	 *            the authorId to set
	 */
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	/**
	 * @return the tags
	 */
	public String getTags() {
		return tags;
	}

	/**
	 * @param tags
	 *            the tags to set
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}

	/**
	 * @return the folderId
	 */
	public int getFolderId() {
		return folderId;
	}

	/**
	 * @param folderId
	 *            the folderId to set
	 */
	public void setFolderId(int folderId) {
		this.folderId = folderId;
	}

	/**
	 * @return the commentCount
	 */
	public int getCommentCount() {
		return commentCount;
	}

	/**
	 * @param commentCount
	 *            the commentCount to set
	 */
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	/**
	 * @return the clickTimes
	 */
	public int getClickTimes() {
		return clickTimes;
	}

	/**
	 * @param clickTimes
	 *            the clickTimes to set
	 */
	public void setClickTimes(int clickTimes) {
		this.clickTimes = clickTimes;
	}

	/**
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime
	 *            the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
