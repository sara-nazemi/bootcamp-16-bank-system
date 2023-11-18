package ir.bootcamp.java.banksystem.models.documents.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@ToString
public class CardToCardTransactionDto {

    private String sourceCardNumber;
    private String targetCardNumber;
    private Double amount;

}
