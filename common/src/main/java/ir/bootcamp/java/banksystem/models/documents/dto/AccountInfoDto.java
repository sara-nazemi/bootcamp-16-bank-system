package ir.bootcamp.java.banksystem.models.documents.dto;

import ir.bootcamp.java.banksystem.models.documents.valid.NotNullGroup;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountInfoDto extends BaseDto {
//    @NotNull(groups = NotNullGroup.class, message = "accountInfo.id.isNull")
    private Long id;
    @NotNull(groups = NotNullGroup.class, message = "accountInfo.number.isNull")
    @Pattern(regexp = "^\\d+$", message = "accountInfo.number.isNotValid")
    @Size(min = 8, max = 8, message = "accountInfo.number.isNotValid")
    private String number;
    @NotNull(groups = NotNullGroup.class, message = "accountInfo.iban.isNull")
    @Pattern(regexp = "^\\w+$", message = "accountInfo.iban.isNotValid")
    private String Iban;
//    @NotNull(groups = NotNullGroup.class, message = "accountInfo.inventory.isNull")
    @DecimalMin(value = "100.0", message = "accountInfo.inventory.isNegative")
    private Double inventory;
    @NotNull(groups = NotNullGroup.class, message = "accountInfo.userId.isNull")
    private Long userId;
    private Integer userVersion;
}
