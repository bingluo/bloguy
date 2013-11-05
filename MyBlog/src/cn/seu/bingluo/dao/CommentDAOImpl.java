package cn.seu.bingluo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Component;

import cn.seu.bingluo.entity.Comment;
import cn.seu.bingluo.entity.CommentPojo;

import com.ibatis.sqlmap.client.SqlMapClient;

@Component
public class CommentDAOImpl extends SqlMapClientDaoSupport implements
		CommentDAO {

	@Autowired(required = true)
	public void setSqlMapClientTemp(SqlMapClient sqlMapClient) {
		setSqlMapClient(sqlMapClient);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CommentPojo> selectCommentsByBlogIdAndBaseAndRank(long id,
			int base, int range) {
		Map<String, Long> map = new HashMap<String, Long>();
		map.put("id", Long.valueOf(id));
		map.put("base", Long.valueOf(base));
		map.put("range", Long.valueOf(range));
		return (List<CommentPojo>) getSqlMapClientTemplate().queryForList(
				"COMMENTS.selectCommentsByBlogIdAndBaseAndRank", map);
	}

	@Override
	public void insertComment(Comment comment) {
		getSqlMapClientTemplate().insert("COMMENTS.insertComment", comment);
	}

	@Override
	public void deleteComment(long id) {
		getSqlMapClientTemplate().delete("COMMENTS.deleteComment", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CommentPojo> selectLatestComment() {
		return getSqlMapClientTemplate().queryForList(
				"COMMENTS.selectLatestComment");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CommentPojo> selectCommentsByCommentedId(long id) {
		return getSqlMapClientTemplate().queryForList(
				"COMMENTS.selectCommentsByCommentedId", id);
	}

}
