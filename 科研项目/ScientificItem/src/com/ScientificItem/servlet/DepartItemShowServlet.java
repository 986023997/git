package com.ScientificItem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ScientificItem.dao.ItemDao;
import com.ScientificItem.dao.impl.ItemDaoImpl;
import com.ScientificItem.model.Item;
import com.ScientificItem.model.User;
import com.ScientificItem.service.ItemService;
import com.ScientificItem.service.impl.ItemServiceImpl;

/**
 * 部门项目显示
 * @author admin
 *
 */
public class DepartItemShowServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//字符处理
				response.setContentType("text/html;charset=UTF-8");
				response.setCharacterEncoding("utf-8");
				request.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				//根据session中登录者的信息，得到登录者的部门
				ItemDao itemDao=new ItemDaoImpl();
				ItemService itemService=new ItemServiceImpl(itemDao);
				User user=null;
				//取得项目的id
				 user=(User) request.getSession().getAttribute("user");
				
				if(user!=null) {
					List<Item> list=itemService.showDepartAllItem(user.getUser_depart_id());
					if(list!=null){
						request.setAttribute("items", list);
						request.getRequestDispatcher("pages/depart_item/departitemlist.jsp").forward(request, response);	
					}else{
						request.getRequestDispatcher("welcome.jsp").forward(request, response);
					}
					
				}else{
			request.getRequestDispatcher("index.jsp").forward(request, response);
				}
	}  
}
