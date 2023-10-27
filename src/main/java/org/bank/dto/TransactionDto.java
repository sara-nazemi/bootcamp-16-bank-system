package org.bank.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bank.converter.valid.NotNullGroup;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto extends BaseDto {
//    @NotNull(groups = NotNullGroup.class, message = "transaction.id.isNull")
    private Long id;
    @NotNull(groups = NotNullGroup.class, message = "transaction.dateTransaction.isNull")
    private Date dateTransaction;
    @NotNull(groups = NotNullGroup.class, message = "transaction.tracking.isNull")
    @Pattern(regexp = "^\\d+$", message = "transaction.tracking.isNotValid")
    private String tracking;
    @NotNull(groups = NotNullGroup.class, message = "transaction.accountInfoId.isNull")
    private Long accountInfoId;
    private Double amount;
    private Integer accountInfoVersion;
}
