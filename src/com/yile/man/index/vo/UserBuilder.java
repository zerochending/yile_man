package com.yile.man.index.vo;

import java.util.Date;


//ϵͳ�û�
public class UserBuilder{
	
	private User user = new User();
	
	public UserBuilder setPwd(String pwd) {
		user.setPwd(pwd);
		return this;
	}

	public UserBuilder setId(int id) {
		user.setId(id);
		return this;
	}
	
	public UserBuilder setLoginName(String loginName) {
		user.setLoginName(loginName);
		return this;
	}

	public UserBuilder setUserName(String userName) {
		user.setUserName(userName);
		return this;
	}

	public UserBuilder setIdetify(String idetify) {
		user.setIdetify(idetify);
		return this;
	}

	public UserBuilder setLoginTime(Date loginTime) {
		user.setLoginTime(loginTime);
		return this;
	}

	public UserBuilder setDeptment(String deptment) {
		user.setDeptment(deptment);
		return this;
	}
	
	public UserBuilder setLoginCount(int loginCount) {
		user.setLoginCount(loginCount);
		return this;
	}

	public UserBuilder setLoginIp(String loginIp) {
		user.setLoginIp(loginIp);
		return this;
	}

	public User toUser() {
		return user;
	}
	
	
}
