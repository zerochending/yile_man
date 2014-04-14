package com.yile.man.index.dao;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yile.man.index.vo.User;

public class LoginDaoImpl extends SqlMapClientDaoSupport implements LoginDao{

	
	public User login(User user) {
		return  (User)this.getSqlMapClientTemplate().queryForObject("login.login",user);
	}
	
	public int recodeUserHis(User user) {
		return  (Integer)this.getSqlMapClientTemplate().update("login.recodeUserHis",user);
	}
	
}
