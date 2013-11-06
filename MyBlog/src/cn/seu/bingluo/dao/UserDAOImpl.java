package cn.seu.bingluo.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Component;

import cn.seu.bingluo.entity.User;

import com.ibatis.sqlmap.client.SqlMapClient;

@Component
public class UserDAOImpl extends SqlMapClientDaoSupport implements UserDAO {

	@Autowired(required = true)
	public void setSqlMapClientTemp(SqlMapClient sqlMapClient) {
		setSqlMapClient(sqlMapClient);
	}

	@Override
	public User selectUserById(int userId) {
		return (User) getSqlMapClientTemplate().queryForObject(
				"USERS.selectUserById", userId);
	}

	@Override
	public int insertUser(User user) {
		return (Integer) getSqlMapClientTemplate().insert("USERS.insertUser",
				user);
	}

	@Override
	public void deleteUserById(int userId) {
		getSqlMapClientTemplate().delete("USERS.deleteUserById", userId);
	}

	@Override
	public void updateAvatar(User user) {
		getSqlMapClientTemplate().update("USERS.updateAvatar", user);
	}

	@Override
	public void updateIntro(User user) {
		getSqlMapClientTemplate().update("USERS.updateIntro", user);
	}

	@Override
	public void updatePassword(User user) {
		getSqlMapClientTemplate().update("USERS.updatePassword", user);
	}

	@Override
	public User selectUserByNameAndPswd(String userName, String password) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userName", userName);
		map.put("password", password);
		return (User) getSqlMapClientTemplate().queryForObject(
				"USERS.selectUserByNameAndPswd", map);
	}
}
