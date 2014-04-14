package com.yile.man.index.dao;

import com.yile.man.index.vo.User;

public interface LoginDao {

	public User login(User user);
	
	public int recodeUserHis(User user);
	
}
