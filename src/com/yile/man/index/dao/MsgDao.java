package com.yile.man.index.dao;

import java.util.List;

import com.yile.man.index.vo.Msg;
import com.yile.man.index.vo.Page;

public interface MsgDao {

	public List<Msg> query(Page<Msg> page);
	
	public int delete(int id);
	
	public int deleteBatch(List<String> ids);
	
	public int update(Msg msg);
	
	public int total();
	
	public int insert(Msg msg);
}
