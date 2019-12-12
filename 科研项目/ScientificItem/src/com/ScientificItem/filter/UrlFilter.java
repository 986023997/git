package com.ScientificItem.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ScientificItem.model.User;
import com.ScientificItem.service.FilterService;
import com.ScientificItem.service.impl.FilterServiceImpl;

/**
 * Servlet Filter implementation class UrlFilter
 */
/**Ȩ�޹�����
 * @author admin
 *
 */
public class UrlFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UrlFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest  request2=(HttpServletRequest) request;
		HttpServletResponse  response2=(HttpServletResponse) response;
		FilterService filterService=new FilterServiceImpl();
		/*����ȡ��¼�ߵ�id��Ȼ�����serviceȥ�õ���¼�ߵ�����Ȩ�ޣ�Ȼ��������·���Աȣ�
		��Ȩ�����Ƿ����������·�����Ӵ�����������У���û�з�����ʾû��Ȩ��*/
		User user=(User) request2.getSession().getAttribute("user");
		//�����˺�id�õ��˺ŵ�Ȩ��
		String limiturl=filterService.getLimitUrl(user.getUser_id());
		//�õ������·��
		String url=request2.getServletPath();
		/*System.out.println(limiturl);
		System.out.println(request2.getServletPath());*/
		//�ж��û���Ȩ�����Ƿ����������·����������������У�������������ʾ�û�����Ȩ���ʡ�
		if(limiturl.contains(url)){
		// pass the request along the filter chain
		chain.doFilter(request, response);
		}
		else{
			request.setAttribute("error", "��Ȩ����");
			request2.getRequestDispatcher("/pages/user_item/error.jsp").forward(request2, response2);
			
			
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
