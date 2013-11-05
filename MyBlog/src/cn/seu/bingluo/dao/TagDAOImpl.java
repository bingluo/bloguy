package cn.seu.bingluo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Component;

import cn.seu.bingluo.entity.Tag;

import com.ibatis.sqlmap.client.SqlMapClient;

@Component
public class TagDAOImpl extends SqlMapClientDaoSupport implements TagDAO {

	@Autowired(required = true)
	public void setSqlMapClientTemp(SqlMapClient sqlMapClient) {
		setSqlMapClient(sqlMapClient);
	}

	@Override
	public Tag selectTagById(long tagId) {
		return (Tag) getSqlMapClientTemplate().queryForObject(
				"TAGS.selectTagById", tagId);
	}

	@Override
	public void insertTag(String tagName) {
		getSqlMapClientTemplate().insert("TAGS.insertTag", tagName);
	}

	@Override
	public void addTagCount(long tagId) {
		getSqlMapClientTemplate().update("TAGS.addBlogCount", tagId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tag> selectAllTags() {
		return getSqlMapClientTemplate().queryForList("TAGS.selectAllTags");
	}

	@Override
	public Tag selectTagByName(String tagName) {
		return (Tag) getSqlMapClientTemplate().queryForObject(
				"TAGS.selectTagByName", tagName);
	}
}
