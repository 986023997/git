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

/**
 * 修改用户密码servlet
 * @author admin
 *
 */
public class UpdatePasswordServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			//字符处理
				response.setContentType("text/html;charset=UTF-8");
				response.setCharacterEncoding("utf-8");
				request.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				/*前端页面进行输入校验，得到旧密码后，并根据session中的id号取出用户密码，进行对比，若相同，则进行更新，
				不相同返回输出错误信息*/
				UserDao userDao=new UserDaoImpl();
				UserService userService=new UserServiceImpl(userDao);
				User user=null;
				String department=null;
				String oldPasssword=request.getParameter("oldpassword");
				String newpassword=request.getParameter("newpassword1");
				
				
				//取登录者信息
				user=(User)request.getSession().getAttribute("user");
				
				if(user!=null) {
				//判断密码是否相等，若不相等则返回到修改密码页面
					if(!oldPasssword.equals(user.getUser_password())) {
						request.setAttribute("error","密码不正确！！！");
						request.getRequestDispatcher("pages/user_info/updatepassword.jsp").forward(request, response);
					}else {
					user=userService.updatePassword(user.getUser_id(),newpassword);
					request.getSession().setAttribute("user",user);
				//request.getRequestDispatcher("welcome.html").forward(request, response);
					response.sendRedirect("welcome.jsp");
					}
				}else {
				request.getRequestDispatcher("login.html").forward(request, response);
	}}
}
