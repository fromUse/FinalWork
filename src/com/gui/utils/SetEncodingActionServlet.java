package com.gui.utils;

import org.apache.struts.action.ActionServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionServlet;

/**
 * 自定义拦截器,在此提前设置字符集编码
 * @author chen-gui
 *
 */
public class SetEncodingActionServlet extends ActionServlet {

protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
// TODO Auto-generated method stub
String encoding = getInitParameter("encoding");
request.setCharacterEncoding(encoding);
response.setCharacterEncoding(encoding);
super.process(request, response);
}

}
