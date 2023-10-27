package org.bank.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bank.converter.valid.NotNullGroup;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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
    @NotNull(groups = NotNullGroup.class, message = "accountInfo.inventory.isNull")
    @DecimalMin(value = "100.0", message = "accountInfo.inventory.isNegative")
    private Double inventory;
    @NotNull(groups = NotNullGroup.class, message = "accountInfo.accountNumber.isNull")
    @Pattern(regexp = "^\\d{16}$", message = "accountInfo.accountNumber.isNotValid")
    private String accountNumber;
    @NotNull(groups = NotNullGroup.class, message = "accountInfo.userId.isNull")
    private Long userId;
    private Integer userVersion;
}
