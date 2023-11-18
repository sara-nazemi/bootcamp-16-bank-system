package ir.bootcamp.java.banksystem.models.documents.dto;

import ir.bootcamp.java.banksystem.models.documents.valid.NotNullGroup;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class TransactionDto extends BaseDto {

    private Long id;

    private Date dateTransaction;

    @Pattern(regexp = "^\\d+$", message = "transaction.tracking.isNotValid")
    private String tracking;
    @NotNull(groups = NotNullGroup.class, message = "transaction.accountInfoId.isNull")
    private Long accountInfoId;
    private Double amount;
    @NotNull(groups = NotNullGroup.class, message = "transaction.accountInfoVersion.isNull")
    private Integer accountInfoVersion;
}
