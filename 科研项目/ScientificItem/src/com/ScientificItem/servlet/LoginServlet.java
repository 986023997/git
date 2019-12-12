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



/**��¼
 * @author admin
 *
 */
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�ַ�����
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		
		UserDao userDao=new UserDaoImpl();
		UserService userService=new UserServiceImpl(userDao);
		User user=null;
		
		//����ҳ��ȡ�����û��������룬���õ�¼ҵ��ȥ��ѯ���ݿ⣬�����ڸ��û����͸�������˺�,�򽫲�ѯ�������˺���Ϣ������session�в�ת���û�����,�������ڣ���Żص���¼ҳ�棬����ʾ����
		
		user = userService.UserLogin(request.getParameter("User_name"), request.getParameter("User_password"));
		if(user!=null) {
		request.getSession().setAttribute("user", user);
		//response.sendRedirect("pages/homepage/IntoStudent.jsp");
		request.getRequestDispatcher("pages/homepage/worker.jsp").forward(request, response);
		}else {
		
			request.setAttribute("msg", "�˺Ż�������󣡣���");
			//response.sendRedirect("index.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		out.close();
	}
	
	

}
