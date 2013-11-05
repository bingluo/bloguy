package cn.seu.bingluo.entity;

import java.util.Date;

public class Folder {
	// 文件夹（归档）ID
	private long folderId;
	// 文件夹名
	private String folderName;
	// 创建时间
	private Date addTime;
	// 该归档下文章数
	private int blogCount;

	/**
	 * @return the folderId
	 */
	public long getFolderId() {
		return folderId;
	}

	/**
	 * @param folderId
	 *            the folderId to set
	 */
	public void setFolderId(long folderId) {
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
