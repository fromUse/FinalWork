package com.gui.action;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.gui.form.UploadActionForm;

/**
 * 
 * 一个用于文件上传
 * 
 * @author chenq
 * 
 */
public class UploadAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UploadActionForm upload = (UploadActionForm) form;
		try {
			FormFile file = upload.getMyfile();
			String title = new String (upload.getTitle().getBytes("utf-8"),"utf-8");
			System.out.println("-------------title---------------  :" + title);
			FileOutputStream fos = new FileOutputStream("/home/chen-gui/opt/"
					+ file.getFileName());

			fos.write(file.getFileData());

			fos.flush();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mapping.findForward("success");
	}

}
