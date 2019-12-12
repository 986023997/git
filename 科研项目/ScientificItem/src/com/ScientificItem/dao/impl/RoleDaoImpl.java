package com.ScientificItem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ScientificItem.dao.RoleDao;
import com.ScientificItem.model.User;
import com.ScientificItem.util.DButil;

public class RoleDaoImpl implements RoleDao {

	public int selectUserRole(int user_id) {
		Connection con = DButil.getConnection();
		ResultSet result = null;
		PreparedStatement pre = null;
		int record=0;
		
		try {
			pre = con.prepareStatement("select * from user_role where Role_id=1 and User_id=?");
			pre.setInt(1,user_id);
			result = pre.executeQuery();
			if(result!=null){	
				record=1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				pre.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return record;
	}

	

}
