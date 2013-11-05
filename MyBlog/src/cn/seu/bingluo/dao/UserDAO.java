package cn.seu.bingluo.dao;

import cn.seu.bingluo.entity.User;

public interface UserDAO {
	/**
	 * 根据ID获取用户
	 * 
	 * @param userId
	 * @return
	 */
	User selectUserById(long userId);

	/**
	 * 插入用户
	 * 
	 * @param user
	 */
	long insertUser(User user);

	/**
	 * 删除用户
	 * 
	 * @param userId
	 */
	void deleteUserById(long userId);

	/**
	 * 更新头像
	 * 
	 * @param user
	 */
	void updateAvatar(User user);

	/**
	 * 更新简介
	 * 
	 * @param user
	 */
	void updateIntro(User user);

	/**
	 * 更新密码
	 * 
	 * @param user
	 */
	void updatePassword(User user);

	/**
	 * 根据用户名和密码获取用户
	 */
	User selectUserByNameAndPswd(String userName, String password);
}
