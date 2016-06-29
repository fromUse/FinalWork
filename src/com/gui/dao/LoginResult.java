package com.gui.dao;

public class LoginResult {

	private boolean loginSuccessed;
	private int errorCode;
	/**密码错误**/
	public  final static int PASS_ERROR = 1;
	/**用户不存在**/
	public final static int NOTFOUND_USER = 0;

	/**用户不存在**/
	public final static int SUCCESS = -1;
	
	/**
	 * @return 返回结果是否成功登陆
	 */
	public boolean isLoginSuccessed() {
		return loginSuccessed;
	}
	/**
	 * 
	 * @return 返回错误代码
	 */
	public int errorCode() {
		return errorCode;
	}
	
	public void setLoginSuccessed(boolean loginSuccessed) {
		this.loginSuccessed = loginSuccessed;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	
}
