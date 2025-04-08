package ir.bootcamp.java.banksystem.sftp.controlleradvice.logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.bootcamp.java.banksystem.models.documents.documents.LogDocument;
import ir.bootcamp.java.banksystem.sftp.repositories.LogRepository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;

@Aspect
@Component
public class ControllerLogger {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerLogger.class);

    private final LogRepository logRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public ControllerLogger(LogRepository logRepository, ObjectMapper objectMapper) {
        this.logRepository = logRepository;
        this.objectMapper = objectMapper;
    }

    @Around("within(ir.bootcamp.java.banksystem.sftp.controllers+)")
    public Object controllerRestLogs(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LogDocument log = new LogDocument();
        log.setMethodName(proceedingJoinPoint.getSignature().getName());
        log.setRequest(proceedingJoinPoint.getArgs());

        Object rstValue;
        try {
            rstValue = proceedingJoinPoint.proceed();
            if (rstValue != null) {
                log.setResponse(rstValue);
            }
            logRepository.save(log);
            LOGGER.info("success request" + objectMapper.writeValueAsString(log));
        } catch (Throwable e) {
            StringWriter writer = new StringWriter();
            PrintWriter printWriter = new PrintWriter(writer);
            e.printStackTrace(printWriter);
            log.setErrorTrace(writer.toString());
            logRepository.save(log);
            LOGGER.error("fail request" + objectMapper.writeValueAsString(log));
            throw e;
        }
        return rstValue;
    }
}
