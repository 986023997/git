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

/**显示所有的以通过部门审核的项目
 * @author admin
 *
 */
public class ChargeDepartItemListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//字符处理
				response.setContentType("text/html;charset=UTF-8");
				response.setCharacterEncoding("utf-8");
				request.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				ItemDao itemDao=new ItemDaoImpl();
				ItemService itemService=new ItemServiceImpl(itemDao);
				User user=null;
				//根据session得到登录者的信息
				 user=(User) request.getSession().getAttribute("user");
				//若有信息,说明登录了，否则过期重新登录
				if(user!=null) {
					//调用itemService得到所有的已通过部门审核的项目
					List<Item> list=itemService.showChargeDepartAllItem();
					if(list!=null){
						request.setAttribute("items", list);
						request.getRequestDispatcher("pages/charge_item/chargeitemlist.jsp").forward(request, response);	
					}else{
						request.getRequestDispatcher("welcome.jsp").forward(request, response);
					}
					
				}else{
			request.getRequestDispatcher("index.jsp").forward(request, response);
				}
	}  
}
