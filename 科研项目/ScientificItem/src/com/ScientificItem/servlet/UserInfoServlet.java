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
 * 员工信息显示
 * @author admin
 *
 */
public class UserInfoServlet extends HttpServlet {
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
				String department=null;
				
				//取登录者信息
				user=(User)request.getSession().getAttribute("user");
				
				if(user!=null) {
				//根据用户的部门id,获取部门名
				 department=userService.getUserDepartment(user.getUser_depart_id());}
				request.setAttribute("department_name", department);
				request.getRequestDispatcher("pages/user_info/userinfo.jsp").forward(request, response);
		
	}

}
