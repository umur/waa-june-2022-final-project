package alumnimanagement.jwt;

import alumnimanagement.repo.UserAuthRepo;
import alumnimanagement.services.impl.UserAuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {
    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private UserAuthServiceImpl authService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
//        var authorization = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhc2hpc2hAbWl1LmVkdSIsInJvbGVzIjoiQURNSU4iLCJpZCI6MSwidXNlck5hbWUiOiJhc2hpc2hAbWl1LmVkdSIsImV4cCI6MTY1NzYxNjc0MiwiaWF0IjoxNjU3NTk4NzQyfQ.n3Hrsd6u9nBvkza7TBeZGntLG0zQ95cAP23kywy93U3aTWPYfpCOr-nFEhR_K-7yHm6KoRPiKD06im5ZmfVvXg";
        String authorization = httpServletRequest.getHeader("Authorization");
        String token = null;
        String userName = null;

        if (null != authorization && authorization.startsWith("Bearer ")) {
            token = authorization.substring(7);
            userName = jwtUtility.getUsernameFromToken(token);
        }

        if (null != userName && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails
                    = authService.loadUserByUsername(userName);

            if (jwtUtility.validateToken(token, userDetails)) {
                String requestedUrl = httpServletRequest.getRequestURI();

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                        = new UsernamePasswordAuthenticationToken(userDetails,
                        null, userDetails.getAuthorities());

                usernamePasswordAuthenticationToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(httpServletRequest)
                );

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }

        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

}
