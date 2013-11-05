package cn.seu.bingluo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.seu.bingluo.dao.UserDAOImpl;
import cn.seu.bingluo.entity.User;
import cn.seu.bingluo.filter.SecurityContextHolder;

@Service
public class UserService {
	@Autowired
	private UserDAOImpl userDAOImpl;

	public User logon(String userName, String password) {
		User user = userDAOImpl.selectUserByNameAndPswd(userName, password);
		return user;
	}

	public void logout() {
		SecurityContextHolder.getSecurityContext().setUser(null);
	}

	public long register(User user) {
		return userDAOImpl.insertUser(user);
	}

	public void modifyPswd(long userId, String password) {
		User user = new User();
		user.setUserId(userId);
		user.setPassword(password);
		userDAOImpl.updatePassword(user);
	}

	public void modifyAvatar(long userId, String avatarUrl) {
		User user = new User();
		user.setUserId(userId);
		user.setAvatarUrl(avatarUrl);
		userDAOImpl.updateAvatar(user);
	}

	public void modifyIntro(long userId, String intro) {
		User user = new User();
		user.setUserId(userId);
		user.setIntro(intro);
		userDAOImpl.updateIntro(user);
	}

	public User getUserById(long userId) {
		return userDAOImpl.selectUserById(userId);
	}
}
