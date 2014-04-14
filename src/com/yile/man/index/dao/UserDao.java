package com.yile.man.index.dao;

import java.util.List;

import com.yile.man.index.vo.Page;
import com.yile.man.index.vo.User;

public interface UserDao {

	public List<User> query(Page<User> page);
	
	public int delete(int id);
	
	public int deleteBatch(List<String> ids);
	
	public int update(User user);
	
	public int insert(User user);
	
	public int total();
	
	public int dup(User user);

}
