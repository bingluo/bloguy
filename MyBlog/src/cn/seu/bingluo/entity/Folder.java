package cn.seu.bingluo.entity;

import java.util.Date;

public class Folder {
	// 文件夹（归档）ID
	private int folderId;
	// 文件夹名
	private String folderName;
	// 文件夹用户ID
	private int folderUserId;
	// 创建时间
	private Date addTime;
	// 该归档下文章数
	private int blogCount;

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
	 * @return the folderName
	 */
	public String getFolderName() {
		return folderName;
	}

	/**
	 * @param folderName
	 *            the folderName to set
	 */
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	/**
	 * @return the folderUserId
	 */
	public int getFolderUserId() {
		return folderUserId;
	}

	/**
	 * @param folderUserId
	 *            the folderUserId to set
	 */
	public void setFolderUserId(int folderUserId) {
		this.folderUserId = folderUserId;
	}

	/**
	 * @return the addTime
	 */
	public Date getAddTime() {
		return addTime;
	}

	/**
	 * @param addTime
	 *            the addTime to set
	 */
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	/**
	 * @return the blogCount
	 */
	public int getBlogCount() {
		return blogCount;
	}

	/**
	 * @param blogCount
	 *            the blogCount to set
	 */
	public void setBlogCount(int blogCount) {
		this.blogCount = blogCount;
	}
}
