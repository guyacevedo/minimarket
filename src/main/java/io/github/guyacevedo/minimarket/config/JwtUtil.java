package io.github.guyacevedo.minimarket.config;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;

/**
 * @Title: JwtUtil.java
 * @Package io.github.guyacevedo.minimarket.config
 * @Descripción: ${TODO} (Describa qué se describe este archivo en una oración)
 * @author guyacevedo  E-mail: guy.acevedoa@gmail.com
 * @date 1/11/2021-9:15:12 p. m.
 * @version V1.0
 */
public class JwtUtil {

	public static final String BEARER = "Bearer ";
	private static final String USER_CLAIM = "user";
	private static final String NAME_CLAIM = "name";
	private static final String ROLE_CLAIM = "role";
	private static final String ISSUER = "guy-acevedo";
	private static final String SECRET = "passwordapi";
	private static final Integer EXPIRE_MILISECONDS = 3600;

	public static void addAuthentication(HttpServletResponse response, String user, String name, String role) {
		response.addHeader("Authorization", BEARER + createToken(user, name, role));
	}

	public static String createToken(String user, String name, String role) {
		Claims claims = new DefaultClaims();

		claims.put(NAME_CLAIM, name);
		claims.put(ROLE_CLAIM, role);
		claims.put(USER_CLAIM, user);

		return Jwts.builder().setClaims(claims).setIssuer(ISSUER).setIssuedAt(new Date()).setNotBefore(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRE_MILISECONDS * 1000))
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();

	}

	public static Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader("Authorization");

		if (token != null) {
			String user = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(BEARER, "")).getBody()
					.get(USER_CLAIM, String.class).toString();
			String role = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(BEARER, "")).getBody()
					.get(ROLE_CLAIM, String.class).toString();
			List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("ROLE_"+role.toUpperCase()));
			return user != null ? new UsernamePasswordAuthenticationToken(user, token, authorities) : null;
		}
		return null;
	}

}
