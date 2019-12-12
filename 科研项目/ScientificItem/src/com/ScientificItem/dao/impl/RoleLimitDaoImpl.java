package com.ScientificItem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ScientificItem.dao.RoleLimitDao;
import com.ScientificItem.util.DButil;

public class RoleLimitDaoImpl implements RoleLimitDao {

	public int findLimitIdByRid(int userRoleId) {
		Connection con = DButil.getConnection();
		ResultSet result = null;
		PreparedStatement pre = null;
		int record=0;
		
		try {
			pre = con.prepareStatement("select Limit_id from role_limit where Role_id=?");
			pre.setInt(1,userRoleId);
			result = pre.executeQuery();
			if(result.next()) {
				record=result.getInt("Limit_id");
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


