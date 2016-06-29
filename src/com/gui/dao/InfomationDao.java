package com.gui.dao;

import java.util.List;

import com.gui.entity.Infomation;
import com.gui.entity.User;

public interface InfomationDao {
	
	/**
	 * 
	 * @return 返回所有话题
	 */
		List<Infomation> getAllInfo();
		/**
		 * 返回指定用户的话题
		 * @param user
		 * @return
		 */
		List<Infomation> getInfobyUser(User user);
		/**
		 * 删除指定话题
		 * @param info
		 */
		void  deletInfo(Infomation info);
		/**
		 * 修改指定话题
		 * @param info
		 */
		void modifyInfo(Infomation info);
		/**
		 * 新增话题
		 * @param info
		 */
		void addInfo(Infomation info);
		
		Infomation getIndoById(int id);
}
