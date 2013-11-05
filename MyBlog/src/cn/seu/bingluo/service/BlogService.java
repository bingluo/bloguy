package cn.seu.bingluo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.seu.bingluo.dao.BlogDAOImpl;
import cn.seu.bingluo.dao.TagDAOImpl;
import cn.seu.bingluo.entity.Blog;
import cn.seu.bingluo.entity.BlogPojo;
import cn.seu.bingluo.entity.Tag;

@Service
public class BlogService {
	@Autowired
	private BlogDAOImpl blogDAOImpl;
	@Autowired
	private TagDAOImpl tagDAOImpl;

	public void deleteBlog(long id) {
		deleteBlog(id);
	}

	public long postBlog(Blog blog) {
		String[] tags = null;
		if (blog.getTags() != null) {
			tags = blog.getTags().split(";");
		}
		StringBuilder sb = new StringBuilder();
		// 只取前三个tag
		for (int i = 0; tags != null && i < tags.length && i < 3; i++) {
			Tag tag = tagDAOImpl.selectTagByName(tags[i]);
			if (tag == null) {
				tagDAOImpl.insertTag(tags[i]);
			} else {
				tagDAOImpl.addTagCount(tag.getTagId());
			}

			if (i > 0) {
				sb.append(";");
			}
			sb.append(tags[i]);
		}
		return blogDAOImpl.insertBlog(blog);
	}

	public BlogPojo getBlogById(long id) {
		BlogPojo blog = blogDAOImpl.selectBlogById(id);
		setTagListForBlog(blog);
		return blog;
	}

	public List<BlogPojo> getBlogsByPageNumAndRange(int pageNum, int range) {
		List<BlogPojo> list = blogDAOImpl.selectBlogsByBaseAndRange(pageNum
				* range, range);
		for (BlogPojo blog : list) {
			setTagListForBlog(blog);
		}
		return list;
	}

	public List<BlogPojo> getPopularBlogs() {
		List<BlogPojo> list = blogDAOImpl.selectHotBlogs();
		for (BlogPojo blog : list) {
			setTagListForBlog(blog);
		}
		return list;
	}

	public void clickBlog(long blogId) {
		blogDAOImpl.addClickTimeById(blogId);
	}

	public List<BlogPojo> getBlogsByFolderId(long folderId) {
		List<BlogPojo> list = blogDAOImpl.selectBlogsByFolderId(folderId);
		for (BlogPojo blog : list) {
			setTagListForBlog(blog);
		}
		return list;
	}

	public List<BlogPojo> getBlogsByTagAndPageNumAndRange(String tag,
			int pageNum, int range) {
		List<BlogPojo> list = blogDAOImpl.selectBlogsByBaseAndRangeAndTagName(
				pageNum * range, range, tag);
		for (BlogPojo blog : list) {
			setTagListForBlog(blog);
		}
		return list;
	}

	public int getUserBlogCount(long userId) {
		return blogDAOImpl.selectBlogsCountByUserId(userId);
	}

	private BlogPojo setTagListForBlog(BlogPojo blog) {
		String[] tags = blog.getTags().split(";");
		List<Tag> tagList = new ArrayList<Tag>();
		for (String tagName : tags) {
			Tag tag = tagDAOImpl.selectTagByName(tagName);
			if (tag != null) {
				tagList.add(tag);
			}
		}
		blog.setTagList(tagList);
		return blog;
	}

	public boolean updateBlog(Blog blog) {
		blogDAOImpl.updateBlog(blog);
		return true;
	}
}