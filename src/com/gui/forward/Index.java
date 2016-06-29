package com.gui.forward;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.gui.dao.InfomationDao;
import com.gui.dao.impl.InfomationDaoImpl;
import com.gui.entity.Infomation;

public class Index extends Action {
		@Override
		public ActionForward execute(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			
			String userName = (String) request.getSession().getAttribute("userName");
			
			if(userName!=null){
					request.setAttribute("userName", userName);
					
			}
			
			InfomationDao infodao = new InfomationDaoImpl();
			
			
			List<Infomation> infolist = infodao.getAllInfo();
			
			System.out.println(infolist);
			request.setAttribute("infolist", infolist);
			
			
			return mapping.findForward("index");
		}
		
		
}
