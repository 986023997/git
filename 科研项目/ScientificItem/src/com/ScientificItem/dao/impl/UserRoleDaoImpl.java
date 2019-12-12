package com.ScientificItem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ScientificItem.dao.UserRoleDao;
import com.ScientificItem.util.DButil;

public class UserRoleDaoImpl implements UserRoleDao {

	public int findRoleIdByUid(int user_id) {
		//通过数据库连接工具类DButil类得到连接
		Connection con = DButil.getConnection();
		ResultSet result = null;
		PreparedStatement pre = null;
		int record=0;
		try {
			pre = con.prepareStatement("select Role_id from user_role where User_id=?");
			pre.setInt(1,user_id);
			result = pre.executeQuery();
			if(result.next()) {
				record=result.getInt("Role_id");
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

	
	 public void addUserRole(int user_id, int role) {
		Connection con = DButil.getConnection();
		ResultSet result = null;
		PreparedStatement pre = null;
		int record=0;
		
		try {
			pre = con.prepareStatement("insert into user_role values (null,?,?)");
			pre.setInt(1, user_id);
			pre.setInt(2, role);
			pre.executeUpdate();
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
		
	}

}
