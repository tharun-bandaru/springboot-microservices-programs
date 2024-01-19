package com.tcs.demo.api.filter;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.tcs.demo.api.security.MyUserDetailsService;
import com.tcs.demo.util.JwtUtil;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        // we will get the request header
        final String authorizationHeader = request.getHeader("Authorization");

        String username = null;
        String jwt = null;

        //if the authorization header not equal to null and authorizationHeader.startsWith Bearer

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);// after Bearer the character starts with 7
            username = jwtUtil.extractUsername(jwt);// from the jwt token extract the username and store in the username variable
        }

	/*
		 *   The SecurityContext will store the authenticationObject if the user get successfully authenticated ,
		 *    the authentication Object contains the user credentials
		 */

		/*
	      The expression securityContextHolder.getAuthentication() == null is checking whether there is currently no authenticated user in the security context.
	      If this condition evaluates to true, it means that there is no authenticated user, which often implies that the user has not logged in or their session has 		expired.

		 */

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

	//then the load the user details using UserDetailsService and validate the token
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

	/*UsernamePasswordAuthenticationToken is a class in Spring Security used to represent an authentication request that includes a username and password.
			 It  is often used in scenarios where users need to provide their credentials (username and password) to log into an application.
			 */
            if (jwtUtil.validateToken(jwt, userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        chain.doFilter(request, response);
    }

}
