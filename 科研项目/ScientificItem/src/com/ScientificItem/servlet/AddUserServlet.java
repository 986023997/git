package com.ScientificItem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ScientificItem.dao.UserDao;
import com.ScientificItem.dao.impl.UserDaoImpl;
import com.ScientificItem.model.User;
import com.ScientificItem.service.UserService;
import com.ScientificItem.service.impl.UserServiceImpl;

public class AddUserServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//字符处理
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//得到表单中的信息
		UserDao userDao=new UserDaoImpl();
		UserService userService=new UserServiceImpl(userDao);
		User user=new User();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String name=(String )request.getParameter("User_name");
		//String id=(String )request.getAttribute("User_id");
		String realname=(String )request.getParameter("User_realname");
		String password=(String )request.getParameter("newpassword1");
		int age=Integer.parseInt(request.getParameter("User_age").toString());
		String sex=(String )request.getParameter("User_sex");
		String mail=(String )request.getParameter("User_mail");
		String address=(String )request.getParameter("User_address");
		String phone=(String )request.getParameter("User_phone");
		int depart_id=Integer.parseInt(request.getParameter("depart"));
		user.setUser_name(name);
		user.setUser_password(password);
		user.setUser_realname(realname);
		user.setUser_age(age);
		user.setUser_sex(sex);
		user.setUser_mail(mail);
		user.setUser_address(address);
		user.setUser_phone(phone);
		user.setUser_depart_id(depart_id);
		int role=Integer.parseInt(request.getParameter("role_id"));
		try {
			user.setUser_date(sdf.parse(request.getParameter("User_date")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(user);
		
	
		int i=userService.userRegin(user,role);
		
		if(i!=0) {
			request.getSession().setAttribute("user", user);
			response.sendRedirect("welcome.jsp");
		//request.getRequestDispatcher("UserInfoServlet").forward(request, response);
		}else {
			//response.sendRedirect("index.jsp");
			request.setAttribute("error","用户名重复");
			request.getRequestDispatcher("pages/error1.jsp").forward(request, response);
		}
		out.close();
	}
	
	

}
