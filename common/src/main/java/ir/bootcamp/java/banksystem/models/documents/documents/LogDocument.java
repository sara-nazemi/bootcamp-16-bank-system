package ir.bootcamp.java.banksystem.models.documents.documents;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document("BankLogs")
@Getter
@Setter
@ToString
public class LogDocument {
    @MongoId
    private String id;
    private Object request;
    private Object response;
    private String methodName;
    private String errorTrace;
}
