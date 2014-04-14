package com.yile.man.index.dao;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yile.man.index.vo.Page;
import com.yile.man.index.vo.User;

public class UserDaoImpl extends SqlMapClientDaoSupport  implements UserDao{

	@Override
	public int delete(int id) {
		return (Integer)this.getSqlMapClientTemplate().delete("user.delete",id);
	}

	@Override
	public int deleteBatch(List<String> ids) {
		return (Integer)this.getSqlMapClientTemplate().delete("user.deleteBatch",ids);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> query(Page<User> page) {
		return (List<User>)this.getSqlMapClientTemplate().queryForList("user.query",page);
	}

	@Override
	public int update(User user) {
		return (Integer)this.getSqlMapClientTemplate().update("user.update",user);
	}

	@Override
	public int total() {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("user.total");
	}

	@Override
	public int insert(User user) {
		return (Integer)this.getSqlMapClientTemplate().insert("user.insert",user);
	}

	@Override
	public int dup(User user) {
		Integer res = (Integer)this.getSqlMapClientTemplate().queryForObject("user.dup",user);
		if(res!=null) {
			return res;
		}else return -1;
	
	}
}
