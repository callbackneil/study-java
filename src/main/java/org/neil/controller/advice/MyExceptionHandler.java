package org.neil.controller.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author neil
 * @date 2018/7/17
 */
@RestControllerAdvice("org.neil.controller")
public class MyExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException() {
        return "";
    }
}
