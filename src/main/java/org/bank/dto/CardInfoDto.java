package org.bank.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bank.converter.valid.NotNullGroup;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CardInfoDto extends BaseDto {
    //    @NotNull(groups = NotNullGroup.class, message = "cardInfo.id.isNull")
    private Long id;
    @Pattern(regexp = "^\\d{16}$", message = "cardInfo.cardNumber.isNotValid")
    private String cardNumber;
    @NotNull(groups = NotNullGroup.class, message = "cardInfo.expireYear.isNull")
    @Pattern(regexp = "^\\d{4}$", message = "cardInfo.expireYear.isNotValid")
    private String expireYear;
    @NotNull(groups = NotNullGroup.class, message = "cardInfo.expireMonth.isNull")
    @Pattern(regexp = "^\\d{2}$", message = "cardInfo.expireMonth.isNotValid")
    private String expireMonth;
    @NotNull(groups = NotNullGroup.class, message = "cardInfo.cvv2.isNull")
    @Pattern(regexp = "^\\d{3}$", message = "cardInfo.cvv2.isNotValid")
    private String cvv2;
    @NotNull(groups = NotNullGroup.class, message = "cardInfo.accountInfoId.isNull")
    private Long accountInfoId;
    private Integer accountInfoVersion;
}
