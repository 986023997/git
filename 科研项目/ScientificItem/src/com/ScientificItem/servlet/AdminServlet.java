package com.ScientificItem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ScientificItem.dao.ItemDao;
import com.ScientificItem.dao.RoleDao;
import com.ScientificItem.dao.impl.ItemDaoImpl;
import com.ScientificItem.dao.impl.RoleDaoImpl;
import com.ScientificItem.model.Item;
import com.ScientificItem.model.User;
import com.ScientificItem.service.ItemService;
import com.ScientificItem.service.RoleService;
import com.ScientificItem.service.impl.ItemServiceImpl;
import com.ScientificItem.service.impl.RoleServiceImpl;

/**管理员验证的servlet
 * @author admin
 *filter可以替代
 */
public class AdminServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//字符处理
				response.setContentType("text/html;charset=UTF-8");
				response.setCharacterEncoding("utf-8");
				request.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				//根据session中登录者的信息，判断登录者的角色是不是管理员若是，则进去若不是则返回，模拟过滤器，
				RoleDao roleDao=new RoleDaoImpl();
				RoleService roleService=new RoleServiceImpl(roleDao);
				
				User user=null;
				 user=(User) request.getSession().getAttribute("user");
				
				if(user!=null) {
				
					int record=roleService.selectUserRole(user.getUser_id());
					
					if(record==1){
						request.getRequestDispatcher("pages/homepage/NewFile.jsp").forward(request, response);	
					}
					else{
						request.setAttribute("error", "您不是管理员无权访问！！！！");
						request.getRequestDispatcher("/pages/user_item/error.jsp").forward(request, response);
					}
				}else{
			request.getRequestDispatcher("index.jsp").forward(request, response);
				}
	}  
}
