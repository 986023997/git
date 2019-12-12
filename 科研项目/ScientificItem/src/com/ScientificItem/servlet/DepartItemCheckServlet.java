package com.ScientificItem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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

/**部门项目审核
 * @author admin
 *
 */
public class DepartItemCheckServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//字符处理
				response.setContentType("text/html;charset=UTF-8");
				response.setCharacterEncoding("utf-8");
				request.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				/*根据session中登录者的信息，
				取出登录者的id和得到的项目id,去更新item*/
				ItemDao itemDao=new ItemDaoImpl();
				ItemService itemService=new ItemServiceImpl(itemDao);
				User user=null;
				Item item=null;
				//取得项目的id
				 user=(User) request.getSession().getAttribute("user");
				 int id=Integer.parseInt(request.getParameter("Id"));
				 int status=Integer.parseInt(request.getParameter("status"));
				if(user!=null) {
					int i=itemService.DepartCheckItem(id,user.getUser_realname(),status);
					if(i!=0){
						if(i==3){
							request.setAttribute("error","科研主管部门已通过，无法拒绝");
							request.getRequestDispatcher("pages/error1.jsp").forward(request, response);
							
							}else{
						request.getRequestDispatcher("DepartItemShowServlet").forward(request, response);	
						}
						}else{
						request.getRequestDispatcher("welcome.jsp").forward(request, response);
					}
					
				}else{
			request.getRequestDispatcher("index.jsp").forward(request, response);
				}
	}

}
