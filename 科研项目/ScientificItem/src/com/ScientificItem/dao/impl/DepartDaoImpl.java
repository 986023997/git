package com.ScientificItem.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ScientificItem.dao.DepartDao;
import com.ScientificItem.model.Depart;
import com.ScientificItem.model.Item;
import com.ScientificItem.util.DButil;

public class DepartDaoImpl implements DepartDao {

	public List<Depart> getAllDepartment() {
		Connection con = DButil.getConnection();

		ResultSet result = null;
		PreparedStatement pre = null;
		Depart depart=null;
		List<Depart> list = new ArrayList<Depart>();

		try {
			pre = con.prepareStatement("select * from department ");
			result=pre.executeQuery();
			while (result.next()) {
				depart=new Depart(result.getInt("Depart_id"),result.getString("Depart_name"));
				list.add(depart);
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

		return list;
	}

}
