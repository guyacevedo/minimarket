package io.github.guyacevedo.minimarket.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

/**
 * @Title: JwtFilter.java
 * @Package io.github.guyacevedo.minimarket.config
 * @Descripción: ${TODO} (Describa qué se describe este archivo en una oración)
 * @author guyacevedo  E-mail: guy.acevedoa@gmail.com
 * @date 1/11/2021-9:15:12 p. m.
 * @version V1.0
 */
public class JwtFilter extends GenericFilterBean {
	private static final Log logger = LogFactory.getLog(JwtFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		try {
			Authentication authentication = JwtUtil.getAuthentication((HttpServletRequest) request);
			SecurityContextHolder.getContext().setAuthentication(authentication);
		} catch (Exception e) {
			logger.error("Error en auth de token: \n" + e);
		}
		chain.doFilter(request, response);
	}

}
