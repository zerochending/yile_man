package com.yile.man.util;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.yile.man.base.Constant;
import com.yile.man.base.ResMsg;

public class PrintUtils {

	public static final Logger log = Logger.getLogger(PrintUtils.class); 
	
	public static void writeOut(HttpServletResponse res, ResMsg resMsg){
		
		byte[] bs;
		try {
			bs = resMsg.toString().getBytes(Constant.charect);
			OutputStream os = res.getOutputStream();
			os.write(bs);
			os.flush();
			os.close();
		} catch (Exception e) {
			log.error("PrintUtils.error:",e);
		} 
		
	}
}
