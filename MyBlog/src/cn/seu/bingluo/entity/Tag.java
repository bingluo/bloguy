package cn.seu.bingluo.entity;

import java.util.Date;

public class Tag {
	private long tagId;
	private String tagName;
	private long blogCount;
	private Date addTime;
	private Date updateTime;

	/**
	 * @return the tagId
	 */
	public long getTagId() {
		return tagId;
	}

	/**
	 * @param tagId
	 *            the tagId to set
	 */
	public void setTagId(long tagId) {
		this.tagId = tagId;
	}

	/**
	 * @return the tagName
	 */
	public String getTagName() {
		return tagName;
	}

	/**
	 * @param tagName
	 *            the tagName to set
	 */
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	/**
	 * @return the blogCount
	 */
	public long getBlogCount() {
		return blogCount;
	}

	/**
	 * @param blogCount
	 *            the blogCount to set
	 */
	public void setBlogCount(long blogCount) {
		this.blogCount = blogCount;
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
