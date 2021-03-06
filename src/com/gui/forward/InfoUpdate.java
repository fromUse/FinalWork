package com.gui.forward;

import java.util.Date;
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
import com.gui.form.InfoReleaseActionForm;

public class InfoUpdate extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String userName = (String) request.getSession().getAttribute("userName");
		/*	if(userName!=null){
					request.setAttribute("userName", userName);
					
			}else{
				return mapping.findForward("login");
			}
			*/
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			InfomationDao infodao = 	new 	InfomationDaoImpl();
			
			
			Infomation info = infodao.getIndoById(id);
			
			request.setAttribute("info", info);
			request.setAttribute("id", id);
			return mapping.findForward("success");
	}
}
