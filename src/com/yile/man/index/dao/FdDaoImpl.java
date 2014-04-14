package com.yile.man.index.dao;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yile.man.index.vo.FeedBack;
import com.yile.man.index.vo.Page;

public class FdDaoImpl extends SqlMapClientDaoSupport implements FdDao{

	@Override
	public int delete(int id) {
		return this.getSqlMapClientTemplate().delete("fd.delete",id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FeedBack> query(Page<FeedBack> page) {
		return (List<FeedBack>)this.getSqlMapClientTemplate().queryForList("fd.query",page);
	}


	@Override
	public int deleteBatch(List<String> ids) {
		return (Integer)this.getSqlMapClientTemplate().delete("fd.deleteBatch",ids);
	}

	@Override
	public int total() {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("fd.total");
	}

	@Override
	public int insert(FeedBack fb) {
		return (Integer)this.getSqlMapClientTemplate().insert("fd.insert",fb);
	}

	@Override
	public int update(FeedBack fb) {
		return (Integer)this.getSqlMapClientTemplate().update("fd.update",fb);
	}

}
