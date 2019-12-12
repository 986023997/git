package com.ScientificItem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//注释代码要到达20%左右

/**
 * 连接数据库的工具类
 * @author pkd
 * @since 1.0
 * @version 1.0
 * @date 2019-8-16
 *
 */
public class DButil {
	
	private static Connection con = null;	
	
	//获取连接
		public static Connection getConnection() {
			
			// 1.加载驱动
			try {
				Class.forName("com.mysql.jdbc.Driver");
				// Class.forName("org.gjt.mm.mysql.Driver");
				System.out.println("加载完毕！");
			} catch (ClassNotFoundException e) {
				System.out.println("加载驱动出错！");
				e.printStackTrace();
				System.exit(1);
			}

			// 2.获取连接
			try {
				con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/scientific?characterEncoding=utf-8", "root", "123456");
				System.out.println("数据库连接成功！");
			} catch (SQLException e) {
				System.out.println("连接数据库出错！");
				e.printStackTrace();
				System.exit(1);
			}
			return con;
		}
		
		
		
		//关闭连接
		public static void closeConnection()
		{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		
		
		// 测试一下
		public static void main(String[] args) {
			getConnection();
		}
		

}
