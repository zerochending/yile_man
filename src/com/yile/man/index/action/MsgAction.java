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
import com.yile.man.index.dao.MsgDao;
import com.yile.man.index.vo.Msg;
import com.yile.man.index.vo.MsgBuilder;
import com.yile.man.index.vo.Page;
import com.yile.man.index.vo.User;
import com.yile.man.util.PrintUtils;


public class MsgAction extends BaseAction{
	
	public static final Logger log = Logger.getLogger("msgman"); 
	
	@Autowired
	private MsgDao msgDao;
	
	public void insert(HttpServletRequest request, HttpServletResponse response){
		try{
			String msgTitle = request.getParameter("msgTitle");
	    	String msgContenxt = request.getParameter("msgContenxt");
	    	String remark = request.getParameter("remark");
	    	User user = (User)request.getAttribute(Constant.LOGIN);
	    	String loginName = Constant.Administrator;
	    	if(user!=null) {
	    		 loginName = user.getLoginName();
	    	}
	    	Msg msg = new MsgBuilder().setMsgTitle(msgTitle)
	                  .setMsgContenxt(msgContenxt).setReleaseTime(new Date())
	                  .setReleaseName(loginName).setRemark(remark).getMsg();
	    	
	    	int res = msgDao.insert(msg);
	    	if(res>0) {
	    		PrintUtils.writeOut(response,new ResMsg<Integer>(true,res));
	    	}else {
	    		PrintUtils.writeOut(response,new ResMsg<Integer>(false,res));
	    	}
		}catch(Exception e) {
			log.error("MsgAction.insert:",e);
		}
		
	}
	
	public void query(HttpServletRequest request, HttpServletResponse response){
		try{
			String pageNoStr = request.getParameter("p");
			int pageNo = 1;
			if(StringUtils.isNotBlank(pageNoStr)) {
				pageNo = Integer.valueOf(pageNoStr);
			}
			
			int totalNum = msgDao.total();
			List<Msg> list = msgDao.query(new Page<Msg>(pageNo,totalNum));
			if(list!=null) {
				Page<Msg> p = new Page<Msg>(pageNo,totalNum);
				p.setList(list);
				PrintUtils.writeOut(response, new ResMsg<Page<Msg>>(true,p));
			}
			
			PrintUtils.writeOut(response,new ResMsg<String>(false,Constant.FAIL));
		}catch(Exception e) {
			log.error("MsgAction.query:",e);
		}
		
		
	}
	
    public void deleteById(HttpServletRequest request, HttpServletResponse response){
    	try{
    		String msgId = request.getParameter("id");
    		if(StringUtils.isBlank(msgId)) {
    			PrintUtils.writeOut(response, new ResMsg<String>(false,Constant.FAIL));
    		}
    		int res = msgDao.delete(Integer.valueOf(msgId));
    		if(res==1) {//success
    			PrintUtils.writeOut(response,new ResMsg<String>(true,Constant.SUCCESS));
    		}else {
    			PrintUtils.writeOut(response,new ResMsg<String>(false,"res is"+res));
    		}
    		
    	}catch(Exception e) {
			log.error("MsgAction.deleteById:",e);
		}
		
		
	}
    
    public void deleteBatch(HttpServletRequest request, HttpServletResponse response){
    	try{
    		String msgIds = request.getParameter("ids");
    		String[] ids = msgIds.split("\\|");
    		List<String> idList = new ArrayList<String>();
    		for(String id:ids) {
    			if(StringUtils.isNotBlank(id)) {
    				idList.add(id);
    			}
    		}
    		if(!idList.isEmpty()) {
    			int res =  msgDao.deleteBatch(idList);
    			if(res==1) {//success
    				PrintUtils.writeOut(response, new ResMsg<String>(true,Constant.SUCCESS)); 
    			}else {
        			PrintUtils.writeOut(response,new ResMsg<String>(false,"res is"+res));
        		}
    		}
    		PrintUtils.writeOut(response,  new ResMsg<String>(false,Constant.FAIL)); 
    	}catch(Exception e) {
			log.error("MsgAction.deleteBatch:",e);
		}
    	
	 }
    
    public void update(HttpServletRequest request, HttpServletResponse response){
    	try{
    		String msgId = request.getParameter("id");
        	if(StringUtils.isBlank(msgId)) {
        		PrintUtils.writeOut(response,new ResMsg<String>(false,Constant.FAIL));
    		}
        	String msgTitle = request.getParameter("msgTitle");
        	String msgContenxt = request.getParameter("msgContenxt");
        	String remark = request.getParameter("remark");
        	Msg msg = new MsgBuilder().setId(Integer.valueOf(msgId)).setMsgTitle(msgTitle)
        			                   .setMsgContenxt(msgContenxt).setReleaseTime(new Date())
        			                   .setRemark(remark).getMsg();
        	
        	int res = msgDao.update(msg);
    		if(res==1) {//success
    			PrintUtils.writeOut(response,new ResMsg<String>(true,Constant.SUCCESS));
    		}
    		PrintUtils.writeOut(response,new ResMsg<String>(false,Constant.FAIL));
    	}catch(Exception e) {
			log.error("MsgAction.update:",e);
		}
    	
		
    }
	
}
