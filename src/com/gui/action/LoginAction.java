package com.gui.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.gui.dao.LoginResult;
import com.gui.dao.impl.UserLogin;
import com.gui.form.LoginActionForm;

/**
 * 
 * @author chenq
 * 
 *         这个类继承Struts下的Action
 * 
 * 
 *         并做出判断后转发到相对应的页面
 * 
 * 
 *         相当于一个Servet的控制器的作用 负责MVC中的C
 * 
 * 
 *         不要把一些业务逻辑代码写在Action中
 * 
 *         因为Action只负责分发和控制页面
 */

public class LoginAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		LoginActionForm loginForm = (LoginActionForm) form;
		
		
		//进行业务表单验证
		String action = validateForm(loginForm,request,response);
		
		return mapping.findForward(action);
	}

	/**
	 * 表单验证
	 * @param loginForm 表单数据
	 * @param request 
	 * @return 返回转发动作
	 */
	private String  validateForm(LoginActionForm loginForm,HttpServletRequest request,HttpServletResponse response) {
		
		String name = loginForm.getUserName();
		String password = loginForm.getPasswd();

		UserLogin userLogin = new UserLogin();

		LoginResult result = userLogin.login(name, password);
		
		if (result.isLoginSuccessed()) {
			System.out.println("登陆成功......");
				request.getSession().setAttribute("userName", name);
				//当上下文url不为空时，跳转回上一个网址
				String refer = request.getHeader("REFERER");
				if(refer!=null &&  !refer.equals("")){
					 try {
						response.sendRedirect(refer);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
			return "success";
		} else {
			switch (result.errorCode()) {
			case LoginResult.NOTFOUND_USER:
				System.out.println("用户不存在");
				request.setAttribute("usermsg", "用户名不存在");
				break;
			case LoginResult.PASS_ERROR:
				System.out.println("密码错误");
				request.setAttribute("passmsg", "密码错误");
				break;
			}

			//request.getSession().setAttribute("userName", name);
			// 当表单验证通过就返回 error 页面 告诉框架并跳转到相关的失败页面
			return "error";
		}
	}
}
