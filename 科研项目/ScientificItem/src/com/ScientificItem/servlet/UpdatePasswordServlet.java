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
 * �޸��û�����servlet
 * @author admin
 *
 */
public class UpdatePasswordServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			//�ַ�����
				response.setContentType("text/html;charset=UTF-8");
				response.setCharacterEncoding("utf-8");
				request.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				/*ǰ��ҳ���������У�飬�õ�������󣬲�����session�е�id��ȡ���û����룬���жԱȣ�����ͬ������и��£�
				����ͬ�������������Ϣ*/
				UserDao userDao=new UserDaoImpl();
				UserService userService=new UserServiceImpl(userDao);
				User user=null;
				String department=null;
				String oldPasssword=request.getParameter("oldpassword");
				String newpassword=request.getParameter("newpassword1");
				
				
				//ȡ��¼����Ϣ
				user=(User)request.getSession().getAttribute("user");
				
				if(user!=null) {
				//�ж������Ƿ���ȣ���������򷵻ص��޸�����ҳ��
					if(!oldPasssword.equals(user.getUser_password())) {
						request.setAttribute("error","���벻��ȷ������");
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
