package cn.seu.bingluo.entity;

import java.util.List;

public class FolderPojo extends Folder {
	private List<BlogPojo> blogList;

	/**
	 * @return the blogList
	 */
	public List<BlogPojo> getBlogList() {
		return blogList;
	}

	/**
	 * @param blogList
	 *            the blogList to set
	 */
	public void setBlogList(List<BlogPojo> blogList) {
		this.blogList = blogList;
	}
}
