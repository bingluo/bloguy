package cn.seu.bingluo.command;

import cn.seu.bingluo.entity.User;
import cn.seu.bingluo.filter.SecurityContextHolder;

public class BaseCommand {
	public boolean isLogon() {
		return SecurityContextHolder.getSecurityContext().getUser() != null;
	}

	public User getBaseUser() {
		return SecurityContextHolder.getSecurityContext().getUser();
	}
}
