package ir.bootcamp.java.banksystem.sftp.controllers.response;

import lombok.*;

import java.util.Date;
import java.util.Objects;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankResponse<T> {

    private String message;
    private String code;
    private Date date;
    private Boolean hasError;
    private T data;
}
