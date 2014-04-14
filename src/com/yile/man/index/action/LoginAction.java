package com.yile.man.index.action;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.yile.man.base.BaseAction;
import com.yile.man.base.Constant;
import com.yile.man.base.ResMsg;
import com.yile.man.base.Constant.RESMSG;
import com.yile.man.index.dao.LoginDao;
import com.yile.man.index.dao.UserDao;
import com.yile.man.index.vo.User;
import com.yile.man.index.vo.UserBuilder;
import com.yile.man.util.IpUtils;
import com.yile.man.util.PrintUtils;


public class LoginAction extends BaseAction{
	
	public static final Logger log = Logger.getLogger("login"); 
	
	@Autowired
	private LoginDao loginDao;
	@Autowired
	private UserDao userDao;
	
	public String login(HttpServletRequest request, HttpServletResponse response){
		try{
			String loginPwd = request.getParameter("loginPwd");
			String loginName = request.getParameter("loginName");
			if(StringUtils.isBlank(loginPwd) || StringUtils.isBlank(loginName)) {
				PrintUtils.writeOut(response, new ResMsg<String>(false,RESMSG.LOGIN_ERROR));
			}
			User isLegUser = loginDao.login(new UserBuilder().setLoginName(loginName)
					                                          .setPwd(loginPwd).toUser());
			if(isLegUser == null) {
				PrintUtils.writeOut(response,  new ResMsg<String>(false,RESMSG.LOGIN_ERROR));
			}
			
			//记录用户登陆信息
			User user = new UserBuilder().setLoginCount(this.getLoginCount(isLegUser))
					                     .setLoginIp(this.getLoginIp(request)).setLoginTime(new Date())
					                     .setLoginName(loginName).toUser();
			loginDao.recodeUserHis(user);
			
			//授权成功
			request.getSession().setAttribute(Constant.LOGIN, isLegUser);
			//登录成功，上次登录历史
			request.getSession().setAttribute("loginHis",isLegUser);
			//PrintUtils.writeOut(response,  new ResMsg<String>(true,RESMSG.LOGIN_SUCCESS));
			return "index/index";
		}catch(Exception e) {
			log.error("login error:",e);
			return "index/error";
		}
		
		
	}
	
	private String  getLoginIp(HttpServletRequest request) {
		return IpUtils.getClientIp(request);
	}
	
	private int getLoginCount(User user) {
		return user.getLoginCount()+1;
	}

}
