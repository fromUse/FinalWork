package com.gui.forward;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.gui.dao.InfomationDao;
import com.gui.dao.UserDao;
import com.gui.dao.impl.InfomationDaoImpl;
import com.gui.dao.impl.UserDaoImpl;
import com.gui.entity.Infomation;
import com.gui.entity.User;

public class MyInfos extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String userName = (String) request.getSession().getAttribute("userName");

		if(userName == null){
			return mapping.findForward("login");
		}
		
		InfomationDao infodao = new InfomationDaoImpl();
		
		UserDao userdao = new  UserDaoImpl();
		User  user = userdao.findUserByuserName(userName);
		
		List<Infomation> infolist = infodao.getInfobyUser(user);
		
		//	System.out.println(infolist);
		request.setAttribute("infolist", infolist);

		return mapping.findForward("success");
	}

}
