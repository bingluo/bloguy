package cn.seu.bingluo.command;

public class ReplyCommand extends BaseCommand {
	private int blogId;
	private int toId;
	private String toType;
	private String content;

	/**
	 * @return the toId
	 */
	public int getToId() {
		return toId;
	}

	/**
	 * @param toId
	 *            the toId to set
	 */
	public void setToId(int toId) {
		this.toId = toId;
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
}