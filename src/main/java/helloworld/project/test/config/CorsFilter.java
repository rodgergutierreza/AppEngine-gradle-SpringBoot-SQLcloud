package helloworld.project.test.config;

import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CorsFilter implements Filter, ConstantAttributes {
	public CorsFilter() {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		response.setHeader(ACCESS_CONTROL_ALLOW_ORIGIN, ASTERISK);
		response.setHeader(ACCESS_CONTROL_ALLOW_METHODS, METHODS);
		response.setHeader(ACCESS_CONTROL_ALLOW_HEADER, HEADERS);
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig filterConfig) {
	}

	@Override
	public void destroy() {
	}

}