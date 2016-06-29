package com.gui.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

/**
 * 
 * @author chenq
 *这类是文件上传的表单处理类
 */
@SuppressWarnings("serial")
public class UploadActionForm extends ActionForm
{

	private String title;
	private FormFile myfile;
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public FormFile getMyfile()
	{
		return myfile;
	}
	public void setMyfile(FormFile myfile)
	{
		this.myfile = myfile;
	}

	
}
