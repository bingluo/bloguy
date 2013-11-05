package cn.seu.bingluo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Component;

import cn.seu.bingluo.entity.Blog;
import cn.seu.bingluo.entity.BlogPojo;

import com.ibatis.sqlmap.client.SqlMapClient;

@Component
public class BlogDAOImpl extends SqlMapClientDaoSupport implements BlogDAO {

	@Autowired(required = true)
	public void setSqlMapClientTemp(SqlMapClient sqlMapClient) {
		setSqlMapClient(sqlMapClient);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BlogPojo> selectBlogsByBaseAndRange(int base, int range) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("base", base);
		map.put("range", range);
		return getSqlMapClientTemplate().queryForList(
				"BLOGS.selectBlogsByBaseAndRange", map);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BlogPojo> selectBlogsByFolderId(long folderId) {
		return getSqlMapClientTemplate().queryForList(
				"BLOGS.selectBlogsByFolderId", folderId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BlogPojo> selectBlogsByBaseAndRangeAndTagName(int base,
			int range, String tagName) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("base", base);
		map.put("range", range);
		map.put("tagName", tagName);
		return getSqlMapClientTemplate().queryForList(
				"BLOGS.selectBlogsByBaseAndRangeAndTagName", map);
	}

	@Override
	public int selectAllBlogsCount() {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"BLOGS.selectAllBlogsCount");
	}

	@Override
	public int selectBlogsCountByUserId(long userId) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"BLOGS.selectBlogsCountByUserId", userId);
	}

	@Override
	public int selectFolderBlogsCount(long folderId) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"BLOGS.selectFolderBlogsCount", folderId);
	}

	@Override
	public int selectTagBlogsCount(String tagName) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"BLOGS.selectTagBlogsCount", tagName);
	}

	@Override
	public long insertBlog(Blog blog) {
		return (Long) getSqlMapClientTemplate()
				.insert("BLOGS.insertBlog", blog);
	}

	@Override
	public BlogPojo selectBlogById(long id) {
		return (BlogPojo) getSqlMapClientTemplate().queryForObject(
				"BLOGS.selectBlogById", id);
	}

	@Override
	public void updateBlog(Blog blog) {
		getSqlMapClientTemplate().update("BLOGS.updateBlog", blog);
	}

	@Override
	public void addClickTimeById(long id) {
		getSqlMapClientTemplate().update("BLOGS.addClickTime", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BlogPojo> selectHotBlogs() {
		return getSqlMapClientTemplate().queryForList("BLOGS.selectHotBlogs");
	}

	@Override
	public void deleteBlogById(long id) {
		getSqlMapClientTemplate().delete("BLOGS.deleteBlogById", id);
	}
}
