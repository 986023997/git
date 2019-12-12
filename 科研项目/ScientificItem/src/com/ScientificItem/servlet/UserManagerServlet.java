package com.ScientificItem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

public class UserManagerServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//字符处理
				response.setContentType("text/html;charset=UTF-8");
				response.setCharacterEncoding("utf-8");
				request.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				UserDao userDao=new UserDaoImpl();
				UserService userService=new UserServiceImpl(userDao);
				User user=null;
				Item item=null;
				//取登录者信息
				user=(User)request.getSession().getAttribute("user");
				
				if(user!=null) {
					
					List<User> user2=userService.getAllUser();
						
						request.setAttribute("users", user2);
						request.getRequestDispatcher("pages/admin/userlist.jsp").forward(request, response);		
				}else{
			request.getRequestDispatcher("index.jsp").forward(request, response);
				}
	}
}
