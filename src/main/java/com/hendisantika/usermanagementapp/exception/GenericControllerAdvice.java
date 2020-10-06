package com.hendisantika.usermanagementapp.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by IntelliJ IDEA.
 * Project : user-management-app
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/10/20
 * Time: 07.42
 */
@ControllerAdvice
public class GenericControllerAdvice {

    @ExceptionHandler(Exception.class)
    public String assertionException(final Exception e) {
        e.printStackTrace();
        return "redirect:/login?error=Something went wrong";
    }
}
