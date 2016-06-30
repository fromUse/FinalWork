package com.gui.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.gui.dao.InfomationDao;
import com.gui.dao.impl.InfomationDaoImpl;

public class DeleteInfoAction extends Action {

	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String userName = (String) request.getSession().getAttribute("userName");
		String id = request.getParameter("id");
		if(userName!=null){
			
			mapping.findForward("login");
		}
		
		InfomationDao infodao = new InfomationDaoImpl();
		
		if(id!=null){
			mapping.findForward("error");
		}
		
		infodao.deletInfo(infodao.getIndoById(Integer.parseInt(id)));
		
		response.sendRedirect("MyInfos.html");
		
		return null;
	}
	
	
}
