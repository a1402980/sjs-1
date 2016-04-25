
package pizzicato.model;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pizzicato.model.dao.KayttajaDAO;
@WebFilter("/*")
public class SecurityFilter implements Filter {
	
	   public void init(FilterConfig filterConfig) throws ServletException
	   {
	   }

	   public void destroy() 
	   {
	   }

	   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	   {
	      
	      HttpServletResponse resp = (HttpServletResponse) response;
	      HttpServletRequest req = (HttpServletRequest) request;
	      String servletPath = req.getServletPath();

	      // Allow access to login functionality.
	      if (servletPath.equals("/Etusivu") || servletPath.equals("/Rekisteroityminen") || servletPath.equals("/ostoskori"))
	      {
	         chain.doFilter(req, resp);
	      } else if (servletPath.endsWith(".css") || servletPath.endsWith(".png") || servletPath.endsWith(".jpg") || servletPath.endsWith(".js") || servletPath.endsWith(".eot") || servletPath.endsWith(".svg")
	    		  || servletPath.endsWith(".ttf") || servletPath.endsWith(".woff") || servletPath.endsWith(".eot")) {
	    	  chain.doFilter(req, resp);
	    	  
	      } else {
	    	  HttpSession session = req.getSession();
		      String kayttaja_rooli = (String) session.getAttribute("rooli");
			  
		      if (kayttaja_rooli != "omistaja")
		      {
		    	  chain.doFilter(req, resp);
		    	 
		      } else {
		    	  resp.sendRedirect("Etusivu");
		      }
		     
	      }

	   }   
	
		
}
