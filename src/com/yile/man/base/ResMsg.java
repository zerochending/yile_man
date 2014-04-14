package com.yile.man.base;

import com.yile.man.util.JSONTools;

public class ResMsg<T>{

	private boolean success;
	private T tips;
	
	public T getTips() {
		return tips;
	}

	public void setTips(T tips) {
		this.tips = tips;
	}

	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}

	
	public ResMsg(){}
	public ResMsg(boolean success, T tips){
		this.success = success;
		this.tips = tips;
	}
	
	public String toString() {
		return JSONTools.TO_JSON(this);
	}
	
}
