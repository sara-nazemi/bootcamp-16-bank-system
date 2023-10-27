package org.bank.controller.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.bank.controller.response.BankResponse;
import org.bank.exception.BankException;
import org.bank.util.ResourceBundleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Date;
import java.util.List;

@ControllerAdvice
public class ControllerExceptionHandler {

    @Autowired
    private ResourceBundleUtil resourceBundleUtil;


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody BankResponse<?> handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException exception,HttpServletRequest request){
        String propertyName = exception.getPropertyName();
        Class<?> requiredType = exception.getRequiredType();

        return BankResponse.builder()
                .message("input parameter " + propertyName + " required this type : " + requiredType)
                .code("xxxx")
                .date(new Date())
                .hasError(true)
                .data(null)
                .build();
    }



    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody BankResponse<?> handleMethodArgumentException(
            MethodArgumentNotValidException argumentNotValidException, HttpServletRequest request) {
        List<FieldError> fieldErrors = argumentNotValidException.getBindingResult().getFieldErrors();
        String code1 = "";
        for (FieldError fieldError : fieldErrors) {
            code1 = fieldError.getDefaultMessage();
        }

        if(code1 == null || code1.isEmpty()) {
            code1 = "bank.method.argument.is.not.valid";
        }

        String message1 = resourceBundleUtil.getMessage(code1, request.getHeader("lang"));
        return BankResponse.builder()
                .message(message1)
                .code(code1)
                .date(new Date())
                .hasError(true)
                .data(null)
                .build();
    }

    @ExceptionHandler(BankException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody BankResponse<?> handleBankException(BankException b, HttpServletRequest request) {
        String code2 = b.getMessage();

        String message2 = resourceBundleUtil.getMessage(code2, request.getHeader("lang"));
        return BankResponse.builder()
                .message(message2)
                .code(code2)
                .date(new Date())
                .hasError(true)
                .data(null)
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody BankResponse<?> handleAnyException(Exception exception, HttpServletRequest request) {
        String lang = request.getHeader("lang");
        String message3 = resourceBundleUtil.getMessage("bank.internal.server.error", lang);
        exception.printStackTrace();
        return BankResponse.builder()
                .message(message3)
                .code("bank.internal.server.error")
                .date(new Date())
                .hasError(true)
                .data(null)
                .build();
    }

}
