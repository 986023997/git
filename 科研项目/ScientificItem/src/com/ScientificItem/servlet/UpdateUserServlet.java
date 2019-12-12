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

/**修改用户信息servlet
 * @author admin
 *
 */
public class UpdateUserServlet extends HttpServlet {
	
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
		System.out.println(request.getParameter("User_realname"));
		//String id=(String )request.getAttribute("User_id");
		int id=Integer.parseInt(request.getParameter("User_id").toString());
		String realname=(String )request.getParameter("User_realname");
		int age=Integer.parseInt(request.getParameter("User_age").toString());
		String sex=(String )request.getParameter("User_sex");
		String mail=(String )request.getParameter("User_mail");
		String address=(String )request.getParameter("User_address");
		String phone=(String )request.getParameter("User_phone");
		user.setUser_id(id);
		user.setUser_realname(realname);
		user.setUser_age(age);
		user.setUser_sex(sex);
		user.setUser_mail(mail);
		user.setUser_address(address);
		user.setUser_phone(phone);
		System.out.println(user);
		
	
		user = userService.userUpdate(user);
		if(user!=null) {
			request.getSession().setAttribute("user", user);
			response.sendRedirect("welcome.jsp");
		//request.getRequestDispatcher("UserInfoServlet").forward(request, response);
		}else {
			//response.sendRedirect("index.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		out.close();
	}
	
}
