package com.gui.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.junit.Test;

import com.gui.dao.InfomationDao;
import com.gui.dao.UserDao;
import com.gui.dao.impl.InfomationDaoImpl;
import com.gui.dao.impl.UserDaoImpl;
import com.gui.entity.Infomation;
import com.gui.entity.User;
import com.gui.form.InfoReleaseActionForm;

public class InfoUpdateAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		InfoReleaseActionForm info = (InfoReleaseActionForm)form;
		//验证表单
		 validateForm(info,request);
		
		return mapping.findForward("success");
	}

	
	private String validateForm(InfoReleaseActionForm info,
			HttpServletRequest request) {
		
		String title = info.getTitle();
		
		String content = info.getContent();
		
		String titleRex = "<script[\\s\\S]*?<\\/script>";
		String id  = request.getParameter("id");
		if(title.matches(titleRex)){
			System.out.println("标题包含脚本,!!!!!");
			return "error";
		}
		if(content.matches(titleRex)){
			System.out.println("内容包含脚本,!!!!!");
			return "error";
		}
		//获取用户id
		UserDao userdao = new UserDaoImpl();
		
		String userName = (String) request.getSession().getAttribute("userName");
		request.setAttribute("userName", userName);
		User user = userdao.findUserByuserName(userName);
		
		Infomation infomation = null;
	
	
		 InfomationDao infodao = new InfomationDaoImpl();
		 infomation =  infodao.getIndoById(Integer.parseInt(id));
		 if(infomation!=null){
		
				infomation.setContent(content);
				infomation.setTitle(title);
			//	infomation.setUser(user);
				
			 infodao.modifyInfo(infomation);
		 }
		
		 
		
		return "success";
	}
	
}
