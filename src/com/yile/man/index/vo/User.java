package com.yile.man.index.vo;

import java.util.Date;

import com.yile.man.util.JSONTools;


//ϵͳ�û�
public class User{
	
	private int id;
	private String loginName;
	private String userName;
	private String idetify;
	private Date loginTime;
	private String deptment;
	private int loginCount;
	private String loginIp;
	private String pwd;
	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getIdetify() {
		return idetify;
	}
	public void setIdetify(String idetify) {
		this.idetify = idetify;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public String getDeptment() {
		return deptment;
	}
	public void setDeptment(String deptment) {
		this.deptment = deptment;
	}
	public int getLoginCount() {
		return loginCount;
	}
	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	
	public String toString() {
		return JSONTools.TO_JSON(this);
	}
	
	
}
