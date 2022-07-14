//package com.example.alumni.exception;
//
//
//
//import com.example.alumni.exception.custom.ApiSubError;
//import com.example.alumni.exception.custom.UserNotFoundException;
//import lombok.extern.slf4j.Slf4j;
//
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.ServletWebRequest;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//@Order(Ordered.HIGHEST_PRECEDENCE)
//@ControllerAdvice
//@Slf4j
//public class RestExceptionHandler extends ResponseEntityExceptionHandler {
//
//    private final String INTERNAL_SERVER_ERROR = "Something went wrong!";
//
//    @ExceptionHandler({UserNotFoundException.class})
//    protected ResponseEntity<Object> handleUserNotFound(
//            RuntimeException ex, WebRequest request) {
//        logger.error(ex.getMessage());
//
//        ApiSubError.ApiError apiError = new ApiSubError.ApiError(HttpStatus.BAD_REQUEST, ex.getMessage(), toPath(request));
//        return buildResponseEntity(apiError);
//    }
//
//
//    @ExceptionHandler({Exception.class})
//    public ResponseEntity<?> handleExceptionHandler(Exception ex, WebRequest request) {
//        logger.error(ex.getMessage());
//        ex.printStackTrace();
//        ApiSubError.ApiError apiError = new ApiSubError.ApiError(HttpStatus.INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR, toPath(request));
//        return buildResponseEntity(apiError);
//    }
//
//    private ResponseEntity<Object> buildResponseEntity(ApiSubError.ApiError apiError) {
//        return new ResponseEntity<>(apiError, apiError.getStatus());
//    }
//
//    private String toPath(WebRequest webRequest){
//        return ((ServletWebRequest)webRequest).getRequest().getRequestURL().toString();
//    }
//
//}