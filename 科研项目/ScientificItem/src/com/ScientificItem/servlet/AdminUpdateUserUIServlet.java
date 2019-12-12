package com.ScientificItem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ScientificItem.dao.ItemDao;
import com.ScientificItem.dao.UserDao;
import com.ScientificItem.dao.impl.ItemDaoImpl;
import com.ScientificItem.dao.impl.UserDaoImpl;
import com.ScientificItem.model.Item;
import com.ScientificItem.model.User;
import com.ScientificItem.service.ItemService;
import com.ScientificItem.service.UserService;
import com.ScientificItem.service.impl.ItemServiceImpl;
import com.ScientificItem.service.impl.UserServiceImpl;

public class AdminUpdateUserUIServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//�ַ�����
				response.setContentType("text/html;charset=UTF-8");
				response.setCharacterEncoding("utf-8");
				request.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				UserDao userDao=new UserDaoImpl();
				UserService userService=new UserServiceImpl(userDao);
				User user=new User();
				Item item=null;
				//ȡ��¼����Ϣ
				user=(User)request.getSession().getAttribute("user");
				
				if(user!=null) {
					//���ݴ��������û�idȥ��ѯ����Ŀ�ľ������ݲ����浽reques
					user=userService.getUserById(Integer.parseInt(request.getParameter("Id")));
					if(user!=null){
						request.setAttribute("user", user);
						request.getRequestDispatcher("pages/admin/userupdate.jsp").forward(request, response);	
					}else{
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
					
				}else{
			request.getRequestDispatcher("index.jsp").forward(request, response);
				}
	}

}
