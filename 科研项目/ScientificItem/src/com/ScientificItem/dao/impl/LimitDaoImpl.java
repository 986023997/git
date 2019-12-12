package com.ScientificItem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ScientificItem.dao.LimitDao;
import com.ScientificItem.util.DButil;

public class LimitDaoImpl implements LimitDao {

	public String findUrlById(int limitId) {
		Connection con = DButil.getConnection();
		ResultSet result = null;
		PreparedStatement pre = null;
		String url=null;
		
		try {
			pre = con.prepareStatement("select Limit_url from limit1 where Limit_id=?");
			pre.setInt(1,limitId);
			result = pre.executeQuery();
			if(result.next()) {
				url=result.getString("Limit_url");
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

		return url;
	}
	}


