package com.yile.man.index.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.yile.man.base.BaseAction;
import com.yile.man.base.Constant;
import com.yile.man.base.ResMsg;
import com.yile.man.index.dao.FdDao;
import com.yile.man.index.vo.FeedBack;
import com.yile.man.index.vo.FeedBackBuilder;
import com.yile.man.index.vo.Page;
import com.yile.man.util.PrintUtils;


public class FeedBackAction extends BaseAction{
	
	public static final Logger log = Logger.getLogger("feedback"); 
	
	@Autowired
	private FdDao fdDao;
	

	public void insert(HttpServletRequest request, HttpServletResponse response){
		try{
			String fdContext = request.getParameter("fdContext");
	    	String connect = request.getParameter("connect");
	    	String companyName = request.getParameter("companyName");
	    	FeedBack fb = new FeedBackBuilder().setCompanyName(companyName).setConnect(connect)
	    			                           .setFdContext(fdContext).setSubmitTime(new Date()).toFeedBack();
	    	
	    	int res = fdDao.insert(fb);
	    	if(res>0) {
	    		PrintUtils.writeOut(response,new ResMsg<Integer>(true,res));
	    	}else {
	    		PrintUtils.writeOut(response,new ResMsg<Integer>(false,res));
	    	}
		}catch(Exception e) {
			log.error("FeedBackAction.insert:",e);
		}
		
	}
	
	public void query(HttpServletRequest request, HttpServletResponse response){
		try{
			String pageNoStr = request.getParameter("p");
			int pageNo = 1;
			if(StringUtils.isNotBlank(pageNoStr)) {
				pageNo = Integer.valueOf(pageNoStr);
			}
			int totalNum = fdDao.total();
			Page<FeedBack> page = new Page<FeedBack> (pageNo,totalNum);
			List<FeedBack> list = fdDao.query(page);
			if(list!=null) {
				Page<FeedBack> p = new Page<FeedBack>(pageNo,totalNum);
				p.setList(list);
				PrintUtils.writeOut(response, new ResMsg<Page<FeedBack>>(true,p));
			}
			PrintUtils.writeOut(response, new ResMsg<String>(false,Constant.FAIL));
		}catch(Exception e) {
			log.error("FeedBackAction.query:",e);
		}
	
		
	}
	
    public void deleteById(HttpServletRequest request, HttpServletResponse response){
    	try{
    		String fdId = request.getParameter("id");
    		if(StringUtils.isBlank(fdId)) {
    			PrintUtils.writeOut(response, new ResMsg<String>(false,Constant.FAIL));
    		}
    		int res = fdDao.delete(Integer.valueOf(fdId));
    		if(res==1) {//success
    			PrintUtils.writeOut(response, new ResMsg<String>(true,Constant.SUCCESS));
    		}else {
    			PrintUtils.writeOut(response, new ResMsg<String>(false,"res is" +res));
    		}
    		
    	}catch(Exception e) {
			log.error("FeedBackAction.deleteById:",e);
		}
		
		
	}
    
    public void deleteBatch(HttpServletRequest request, HttpServletResponse response){
    	try{
    		String fdIds = request.getParameter("ids");
    		String[] ids = fdIds.split("\\|");
    		List<String> idList = new ArrayList<String>();
    		for(String id:ids) {
    			if(StringUtils.isNotBlank(id)) {
    				idList.add(id);
    			}
    		}
    		if(!idList.isEmpty()) {
    			int res =  fdDao.deleteBatch(idList);
    			if(res==1) {//success
    				PrintUtils.writeOut(response, new ResMsg<String>(true,Constant.SUCCESS)); 
    			}else {
    				PrintUtils.writeOut(response, new ResMsg<String>(false,"res is"+res)); 
    			}
    			
    		}
    		PrintUtils.writeOut(response,  new ResMsg<String>(false,Constant.FAIL)); 
    	}catch(Exception e) {
			log.error("FeedBackAction.deleteBatch:",e);
		}
		
		
	 }
	
}
