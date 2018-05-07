/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.web.front;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.web.BaseController;

/**
 * 交通事故查询Controller
 * @author tom
 * @version 2017-12-17
 */
@Controller
@RequestMapping(value = "${frontPath}/zsys/ZPic")
public class ZPicFrontController extends BaseController {

	
	@RequestMapping(value = {"showPic", ""})
	public void showPic(String filePath,HttpServletRequest request, HttpServletResponse response, Model model) {
		String baseDir = Global.getUserfilesBaseDir();
		String path = baseDir+getFirestPic(filePath.split(Global.USERFILES_BASE_URL)[1]);
		FileInputStream in;  
		response.setContentType("application/octet-stream;charset=UTF-8");  
		try {
			in=new FileInputStream(path);
			int i=in.available();  
            byte[]data=new byte[i];  
            in.read(data);  
            in.close();  
            OutputStream outputStream=new BufferedOutputStream(response.getOutputStream());  
            outputStream.write(data);  
            outputStream.flush();  
            outputStream.close();  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private String getFirestPic(String filePath) {
		filePath = filePath.trim();
		while(filePath.startsWith("|")) {
			filePath = filePath.substring(1, filePath.length());
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append(Global.USERFILES_BASE_URL+"/");
		for(String item: filePath.split("")) {
			if("|".equals(item)) {
				break;
			}
			sb.append(item);
		}
		return sb.toString();
	}

	

}