package com.yile.man.index.dao;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yile.man.index.vo.Msg;
import com.yile.man.index.vo.Page;

public class MsgDaoImpl extends SqlMapClientDaoSupport implements MsgDao{

	@Override
	public int delete(int id) {
		return (Integer)this.getSqlMapClientTemplate().delete("msg.delete",id);
	}

	@Override
	public int deleteBatch(List<String> ids) {
		return (Integer)this.getSqlMapClientTemplate().delete("msg.deleteBatch",ids);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Msg> query(Page<Msg> page) {
		return (List<Msg>)this.getSqlMapClientTemplate().queryForList("msg.query",page);
	}

	@Override
	public int update(Msg msg) {
		return (Integer)this.getSqlMapClientTemplate().update("msg.update",msg);
	}

	@Override
	public int total() {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("msg.total");
	}

	@Override
	public int insert(Msg msg) {
		return (Integer)this.getSqlMapClientTemplate().insert("msg.insert",msg);
	}

	
	
}
