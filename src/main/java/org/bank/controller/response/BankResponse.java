package org.bank.controller.response;

import lombok.*;
import org.bank.dto.BaseDto;

import java.util.Date;


@Getter
@Setter
@Builder()
@AllArgsConstructor
@NoArgsConstructor
public class BankResponse<T> {

    private String message;
    private String code;
    private Date date;
    private Boolean hasError;

    private T data;
}
