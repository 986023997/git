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

public class DeleteUserServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//字符处理
				response.setContentType("text/html;charset=UTF-8");
				response.setCharacterEncoding("utf-8");
				request.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				//根据session中登录者的信息，去查找去登录者的部门
				UserDao userDao=new UserDaoImpl();
				UserService userService=new UserServiceImpl(userDao);
				User user=null;
				Item item=null;
				//取得需要删除的账号id
				 user=(User) request.getSession().getAttribute("user");
				 int id=Integer.parseInt(request.getParameter("Id"));
				
				if(user!=null) {
					int i=userService.deleteUser(id);
					if(i!=0){
						request.getRequestDispatcher("DeleteItemServlet").forward(request, response);	
					}else{
						request.getRequestDispatcher("pages/user_item/itemlist.jsp").forward(request, response);
					}
					
				}else{
			request.getRequestDispatcher("index.jsp").forward(request, response);
				}
	}  
}
