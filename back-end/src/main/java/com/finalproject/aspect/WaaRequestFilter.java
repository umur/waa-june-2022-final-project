//package com.finalproject.aspect;
//
//import com.finalproject.aspect.Exception.OffensiveException;
//import com.finalproject.repository.OffensiveRepo;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//@AllArgsConstructor
//public class WaaRequestFilter extends OncePerRequestFilter {
//
//    @Autowired
//    private OffensiveRepo offensiveRepo;
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        if (request.getRequestURI().equals("/api/v1/products") && request.getMethod().equals("POST") || request.getMethod().equals("PUT")) {
//            var user = request.getUserPrincipal().getName();
//            var reqCounts = offensiveRepo.findByUserName(user);
//            System.out.println(reqCounts);
//            if (reqCounts !=null) {
//                if (reqCounts.getCount() >4) {
//                long time = reqCounts.ban();
//                    if (time > 0) {
//                        filterChain.doFilter(request, response);
//                    }
//                    throw new OffensiveException("Max Bad Words Requests Limit has been Reached. You need wait for X minutes");
//                }
//            }
//        }
//        filterChain.doFilter(request, response);
//    }
//}
