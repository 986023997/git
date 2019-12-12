package com.ScientificItem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
 * 项目内容显示
 * @author admin
 *
 */
public class ShowContentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//字符处理
				response.setContentType("text/html;charset=UTF-8");
				response.setCharacterEncoding("utf-8");
				request.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				ItemDao itemDao=new ItemDaoImpl();
				ItemService itemService=new ItemServiceImpl(itemDao);
				User user=null;
				Item item=null;
				//取登录者信息
				user=(User)request.getSession().getAttribute("user");
				
				if(user!=null) {
					//根据页面传过来的项目id将项目查询出来，若查询出来，则保存到request中并传到页面
					item=itemService.showItemById(Integer.parseInt(request.getParameter("Id")));
					if(item!=null){
						request.setAttribute("item", item);
						request.getRequestDispatcher("pages/user_item/showconten.jsp").forward(request, response);	
					}else{
						request.getRequestDispatcher("welcome.jsp").forward(request, response);
					}
					
				}else{
			request.getRequestDispatcher("index.jsp").forward(request, response);
				}
	}
	

}
