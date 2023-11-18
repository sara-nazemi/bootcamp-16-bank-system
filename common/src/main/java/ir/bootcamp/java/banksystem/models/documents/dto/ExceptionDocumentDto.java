package ir.bootcamp.java.banksystem.models.documents.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionDocumentDto {
    private String id;
    private String message;
    private String code;
    private String date;
}
