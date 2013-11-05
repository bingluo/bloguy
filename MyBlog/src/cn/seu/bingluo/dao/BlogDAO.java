package cn.seu.bingluo.dao;

import java.util.List;

import cn.seu.bingluo.entity.Blog;
import cn.seu.bingluo.entity.BlogPojo;

public interface BlogDAO {
	/**
	 * 根据base和range返回博客
	 * 
	 * @param base
	 * @param range
	 * @return
	 */
	List<BlogPojo> selectBlogsByBaseAndRange(int base, int range);

	/**
	 * 根据base、range和归档Id返回相应博客
	 * 
	 * @param base
	 * @param range
	 * @param folderId
	 * @return
	 */
	List<BlogPojo> selectBlogsByFolderId(long folderId);

	/**
	 * 根据base、range和tag返回相应博客
	 * 
	 * @param base
	 * @param range
	 * @param tagName
	 * @return
	 */
	List<BlogPojo> selectBlogsByBaseAndRangeAndTagName(int base, int range,
			String tagName);

	/**
	 * 根据用户Id获取博客总数
	 * 
	 * @param userId
	 * @return
	 */
	int selectBlogsCountByUserId(long userId);

	/**
	 * 返回博客总数
	 * 
	 * @return
	 */
	int selectAllBlogsCount();

	/**
	 * 返回相应归档下的博客总数
	 * 
	 * @param folderId
	 * @return
	 */
	int selectFolderBlogsCount(long folderId);

	/**
	 * 返回相应tag下的博客总数
	 * 
	 * @param tagName
	 * @return
	 */
	int selectTagBlogsCount(String tagName);

	/**
	 * 插入blog
	 * 
	 * @param blog
	 */
	long insertBlog(Blog blog);

	/**
	 * 返回id对应的blog
	 * 
	 * @param id
	 * @return
	 */
	BlogPojo selectBlogById(long id);

	/**
	 * 更新blog
	 * 
	 * @param blog
	 */
	void updateBlog(Blog blog);

	/**
	 * 点击量+1
	 */
	void addClickTimeById(long id);

	/**
	 * 获取热门文章
	 * 
	 * @return
	 */
	List<BlogPojo> selectHotBlogs();

	/**
	 * 删除文章
	 * 
	 * @param id
	 */
	void deleteBlogById(long id);
}
