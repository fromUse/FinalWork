package com.gui.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.gui.dao.UserRegisterDao;
import com.gui.dao.impl.UserRegister;
import com.gui.entity.User;
import com.gui.form.RegisterActionForm;

public class RegisterAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		RegisterActionForm registerActionForm = (RegisterActionForm) form;

		//进行业务表单验证
		String action = validateForm(registerActionForm,request);
		
		// request.setAttribute("msg", "注册成功");

		System.out.println(form);

		return mapping.findForward(action);
	}

	private String validateForm(RegisterActionForm registerActionForm,
			HttpServletRequest request) {
		
		String userName = registerActionForm.getUserName().equals("") ? null
				: registerActionForm.getUserName();

		String passWord = registerActionForm.getPassWord().equals("") ? null
				: registerActionForm.getPassWord();

		String notPassword = registerActionForm.getNotPassword().equals("") ? null
				: registerActionForm.getNotPassword();

		// String sex = new
		// String(registerActionForm.getSex().getBytes("iso-8859-1"),"utf-8");

		String sex = registerActionForm.getSex().equals("") ? null
				: registerActionForm.getSex();

		String code = registerActionForm.getCode().equals("") ? null
				: registerActionForm.getCode();

		String session_code = (String) request.getSession()
				.getAttribute("checkcode");
		
/**----------------------------------------------服务端验证用户名是否合法------------------------------------------------------------**/		
		if(userName.matches("^[a-zA-Z][a-zA-Z\\d]{3,15}$")){
			System.out.println(">>>>>>>>用户名验证通过");
		}else{
			System.out.println(">>>>>>>>用户名验证不通过");
			request.setAttribute("uservalidate", "用户名验证不通过");
			return "error";
		}
/**----------------------------------------------服务端验证密码合法性------------------------------------------------------------**/			
		if(passWord.matches("^[A-Za-z][\\da-zA-Z._-]{5,15}$")){
			System.out.println(">>>>>>>>密码验证通过");		
		}else{
			System.out.println(">>>>>>>>密码验证不通过");
			request.setAttribute("passwdvalidate", "密码验证不通过");
			return "error";
		}
/**----------------------------------------------服务端二次验证密码合法性------------------------------------------------------------**/			
		if(notPassword.matches("^[A-Za-z][\\da-zA-Z._-]{5,15}$") && passWord.equals(notPassword)){
			System.out.println(">>>>>>>>密码验证通过");		
		}else{
			System.out.println(">>>>>>>>密码验证不通过,或密码不一致");
			request.setAttribute("notpasswdvalidate", "密码验证不通过,或密码不一致");
			return "error";
		}	
/**----------------------------------------------服务端验证密码验证码------------------------------------------------------------**/	
		if (!session_code.equals(code)) {
			request.setAttribute("check_msg", "验证码不正确");
			return "error";
		} else {
				User user = new User(userName, passWord, sex);
				UserRegisterDao userRegister = new UserRegister();
				userRegister.registerUser(user);
				return "success";
		}
	}

}
