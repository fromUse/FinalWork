package com.gui.form;

import org.apache.struts.action.ActionForm;

public class InfoReleaseActionForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1905252757486594721L;
	private String title;
	private String content;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "InfoReleaseActionForm [title=" + title + ", content=" + content
				+ "]";
	}
	
	
}
