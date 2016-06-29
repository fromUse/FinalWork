package com.gui.forward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class InfoRelease extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String userName = (String) request.getSession().getAttribute("userName");
		if(userName!=null){
				request.setAttribute("userName", userName);
				
		}else{
			return mapping.findForward("login");
		}
		
		return mapping.findForward("inforelease");
	}
	
}
