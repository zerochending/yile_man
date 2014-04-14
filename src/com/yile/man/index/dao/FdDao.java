package com.yile.man.index.dao;

import java.util.List;

import com.yile.man.index.vo.FeedBack;
import com.yile.man.index.vo.Page;

public interface FdDao {

	public List<FeedBack> query(Page<FeedBack> page);
		
	public int delete(int id);
	
	public int deleteBatch(List<String> ids);
	
	public int total();
	
	public int insert(FeedBack fb);
	
	public int update(FeedBack fb);
}
