package ir.bootcamp.java.banksystem.sftp.controllers.exception;

import ir.bootcamp.java.banksystem.models.documents.documents.ExceptionDocument;
import ir.bootcamp.java.banksystem.sftp.controllers.response.BankResponse;
import ir.bootcamp.java.banksystem.sftp.exception.BankException;
import ir.bootcamp.java.banksystem.sftp.services.ExceptionDocumentService;
import ir.bootcamp.java.banksystem.sftp.util.ResourceBundleUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @Autowired
    ExceptionDocumentService exceptionDocumentService;
    // todo use logger
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody BankResponse<?> handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException exception, HttpServletRequest request) {
        String propertyName = exception.getPropertyName();
        Class<?> requiredType = exception.getRequiredType();

        ExceptionDocument exceptionDocument = new ExceptionDocument();
        exceptionDocument.setMessage("input parameter " + propertyName + " required this type : " + requiredType);
        exceptionDocument.setCode("internal.server.error");
        exceptionDocumentService.saveException(exceptionDocument);

        String lang = request.getHeader("lang");
        return BankResponse.builder()
                .message(resourceBundleUtil.getMessage("internal.server.error", lang))
                .code("internal.server.error")
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

        if (code1 == null || code1.isEmpty()) {
            code1 = "bank.method.argument.is.not.valid";
        }

        // todo below code is duplicate
        return getBankResponse(request, code1);
    }

    private BankResponse<?> getBankResponse(HttpServletRequest request, String code1) {
        String message1 = resourceBundleUtil.getMessage(code1, request.getHeader("lang"));

        ExceptionDocument exceptionDocument = new ExceptionDocument();
        exceptionDocument.setMessage(message1);
        exceptionDocument.setCode(code1);
        exceptionDocumentService.saveException(exceptionDocument);

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

        return getBankResponse(request, code2);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody BankResponse<?> handleAnyException(Exception exception, HttpServletRequest request) {
        String lang = request.getHeader("lang");
        String message3 = resourceBundleUtil.getMessage("bank.internal.server.error", lang);

        // todo avoid this, use logger instead
        LOGGER.error("Error occurred in controller!", exception);

        ExceptionDocument exceptionDocument = new ExceptionDocument();
        exceptionDocument.setMessage(message3);
        exceptionDocument.setCode("bank.internal.server.error");
        exceptionDocumentService.saveException(exceptionDocument);

        return BankResponse.builder()
                .message(message3)
                .code("bank.internal.server.error")
                .date(new Date())
                .hasError(true)
                .data(null)
                .build();
    }


}
