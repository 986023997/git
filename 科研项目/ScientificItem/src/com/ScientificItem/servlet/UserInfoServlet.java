package com.ScientificItem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.print.DocFlavor.STRING;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ScientificItem.dao.UserDao;
import com.ScientificItem.dao.impl.UserDaoImpl;
import com.ScientificItem.model.User;
import com.ScientificItem.service.UserService;
import com.ScientificItem.service.impl.UserServiceImpl;

/**
 * Ա����Ϣ��ʾ
 * @author admin
 *
 */
public class UserInfoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//�ַ�����
				response.setContentType("text/html;charset=UTF-8");
				response.setCharacterEncoding("utf-8");
				request.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				//����session�е�¼�ߵ���Ϣ��ȥ����ȥ��¼�ߵĲ���
				UserDao userDao=new UserDaoImpl();
				UserService userService=new UserServiceImpl(userDao);
				User user=null;
				String department=null;
				
				//ȡ��¼����Ϣ
				user=(User)request.getSession().getAttribute("user");
				
				if(user!=null) {
				//�����û��Ĳ���id,��ȡ������
				 department=userService.getUserDepartment(user.getUser_depart_id());}
				request.setAttribute("department_name", department);
				request.getRequestDispatcher("pages/user_info/userinfo.jsp").forward(request, response);
		
	}

}
