package com.ScientificItem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ScientificItem.dao.UserDao;
import com.ScientificItem.dao.impl.UserDaoImpl;
import com.ScientificItem.model.User;
import com.ScientificItem.service.UserService;
import com.ScientificItem.service.impl.UserServiceImpl;



/**登录
 * @author admin
 *
 */
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//字符处理
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		
		UserDao userDao=new UserDaoImpl();
		UserService userService=new UserServiceImpl(userDao);
		User user=null;
		
		//根据页面取到的用户名和密码，调用登录业务去查询数据库，若存在该用户名和该密码的账号,则将查询出来的账号信息保存在session中并转到用户中心,若不存在，则放回到登录页面，并提示错误
		
		user = userService.UserLogin(request.getParameter("User_name"), request.getParameter("User_password"));
		if(user!=null) {
		request.getSession().setAttribute("user", user);
		//response.sendRedirect("pages/homepage/IntoStudent.jsp");
		request.getRequestDispatcher("pages/homepage/worker.jsp").forward(request, response);
		}else {
		
			request.setAttribute("msg", "账号或密码错误！！！");
			//response.sendRedirect("index.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		out.close();
	}
	
	

}
