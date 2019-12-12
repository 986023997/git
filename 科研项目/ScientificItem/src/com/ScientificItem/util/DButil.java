package com.ScientificItem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//ע�ʹ���Ҫ����20%����

/**
 * �������ݿ�Ĺ�����
 * @author pkd
 * @since 1.0
 * @version 1.0
 * @date 2019-8-16
 *
 */
public class DButil {
	
	private static Connection con = null;	
	
	//��ȡ����
		public static Connection getConnection() {
			
			// 1.��������
			try {
				Class.forName("com.mysql.jdbc.Driver");
				// Class.forName("org.gjt.mm.mysql.Driver");
				System.out.println("������ϣ�");
			} catch (ClassNotFoundException e) {
				System.out.println("������������");
				e.printStackTrace();
				System.exit(1);
			}

			// 2.��ȡ����
			try {
				con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/scientific?characterEncoding=utf-8", "root", "123456");
				System.out.println("���ݿ����ӳɹ���");
			} catch (SQLException e) {
				System.out.println("�������ݿ����");
				e.printStackTrace();
				System.exit(1);
			}
			return con;
		}
		
		
		
		//�ر�����
		public static void closeConnection()
		{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		
		
		// ����һ��
		public static void main(String[] args) {
			getConnection();
		}
		

}
