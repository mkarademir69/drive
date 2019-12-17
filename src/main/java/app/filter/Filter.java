package app.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

@Component
public class Filter implements javax.servlet.Filter
{
	public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain) throws IOException,ServletException
	{
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		if(request.getRequestURI().startsWith("/Login"))
			chain.doFilter(request,response);
		else if(request.getSession()!=null&&request.getSession().getAttribute("user")!=null)
			chain.doFilter(request,response);
		else
			response.sendRedirect("/Login");
	}
	public void init(FilterConfig filterConfig) throws ServletException{}
	public void destroy(){}
}