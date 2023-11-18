package ir.bootcamp.java.banksystem.models.documents.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@ToString
public class CardToCardDto extends TransactionDto {

    //@NotNull(groups = NotNullGroup.class, message = "transaction.accountInfoId.isNull")
    //private String cardInfoSource;

    //@NotNull(groups = NotNullGroup.class, message = "transaction.accountInfoId.isNull")
    //private String cardInfoTarget;
}
