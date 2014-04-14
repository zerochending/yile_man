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
import com.yile.man.index.dao.UserDao;
import com.yile.man.index.vo.Page;
import com.yile.man.index.vo.User;
import com.yile.man.index.vo.UserBuilder;
import com.yile.man.util.PrintUtils;


public class UserMagAction extends BaseAction{
	
	public static final Logger log = Logger.getLogger("userman"); 
	
	@Autowired
	private UserDao userDao;
	
	public void insert(HttpServletRequest request, HttpServletResponse response){
		try{
			String loginName = request.getParameter("loginName");
	    	String userName = request.getParameter("userName");
	    	String idetify = request.getParameter("idetify");
	    	String deptment = request.getParameter("deptment");
	    	String pwd = request.getParameter("pwd");
	    	User user = new UserBuilder().setDeptment(deptment).setIdetify(idetify)
	    			                     .setLoginName(loginName).setUserName(userName)
	    			                     .setPwd(pwd).setLoginTime(new Date()).toUser();
	    	if(isDup(user)) {
	    		PrintUtils.writeOut(response,new ResMsg<String>(false,user.getLoginName()+" is alerad exit!"));
	    		return;
	    	}
	    	int res = userDao.insert(user);
	    	if(res>0) {
	    		PrintUtils.writeOut(response,new ResMsg<Integer>(true,res));
	    	}else {
	    		PrintUtils.writeOut(response,new ResMsg<Integer>(false,res));
	    	}
		}catch(Exception e) {
			log.error("UserMagAction.insert:",e);
		}
		
	}
	
	private boolean isDup(User user) {
		int res = userDao.dup(user);
		if(res>0) {
			return true;
		}else 
			return false;
	}
	
	public void query(HttpServletRequest request, HttpServletResponse response){
		try{
			String pageNoStr = request.getParameter("p");
			int pageNo = 1;
			if(StringUtils.isNotBlank(pageNoStr)) {
				pageNo = Integer.valueOf(pageNoStr);
			}
			
			int totalNum = userDao.total();
			List<User> list = userDao.query(new Page<User>(pageNo,totalNum));
			if(list!=null) {
				Page<User> p = new Page<User>(pageNo,totalNum);
				p.setList(list);
				PrintUtils.writeOut(response, new ResMsg<Page<User>>(true,p));
			}
			
			PrintUtils.writeOut(response,new ResMsg<String>(false,Constant.FAIL));
		}catch(Exception e) {
			log.error("UserMagAction.query:",e);
		}
		
	}
	
    public void deleteById(HttpServletRequest request, HttpServletResponse response){
    	try{
    		String userId = request.getParameter("id");
    		if(StringUtils.isBlank(userId)) {
    			PrintUtils.writeOut(response, new ResMsg<String>(false,"user id is blank"));
    		}
    		int res = userDao.delete(Integer.valueOf(userId));
    		if(res==1) {//success
    			PrintUtils.writeOut(response,new ResMsg<String>(true,Constant.SUCCESS));
    		}else {
    			PrintUtils.writeOut(response,new ResMsg<String>(false,"res is "+res));
    		}
    	}catch(Exception e) {
			log.error("UserMagAction.deleteById:",e);
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
    			int res =  userDao.deleteBatch(idList);
    			if(res==1) {//success
    				PrintUtils.writeOut(response, new ResMsg<String>(true,Constant.SUCCESS)); 
    			}else {
    				PrintUtils.writeOut(response, new ResMsg<String>(false,"res is "+res)); 
    			}
    			
    		}
    		PrintUtils.writeOut(response,  new ResMsg<String>(false,"user delete batch ids is null")); 
    	}catch(Exception e) {
			log.error("UserMagAction.deleteBatch:",e);
		}
    	
	 }
    
    public void update(HttpServletRequest request, HttpServletResponse response){
    	try{
    		String userId = request.getParameter("id");
        	if(StringUtils.isBlank(userId)) {
        		PrintUtils.writeOut(response,new ResMsg<String>(false,Constant.FAIL));
    		}
        	String loginName = request.getParameter("loginName");
        	String userName = request.getParameter("userName");
        	String idetify = request.getParameter("idetify");
        	String deptment = request.getParameter("deptment");
        	String pwd = request.getParameter("pwd");
        	User user = new UserBuilder().setDeptment(deptment).setIdetify(idetify)
    			                .setLoginName(loginName).setUserName(userName)
    			                .setPwd(pwd).setLoginTime(new Date()).toUser();	
        	
        	int res = userDao.update(user);
    		if(res==1) {//success
    			PrintUtils.writeOut(response,new ResMsg<String>(true,Constant.SUCCESS));
    		}else {
    			PrintUtils.writeOut(response,new ResMsg<String>(false,"res is "+res));
    		}
    	}catch(Exception e) {
			log.error("UserMagAction.update:",e);
		}
		
    }
}
