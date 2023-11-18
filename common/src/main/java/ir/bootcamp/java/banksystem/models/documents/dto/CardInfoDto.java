package ir.bootcamp.java.banksystem.models.documents.dto;

import ir.bootcamp.java.banksystem.models.documents.valid.NotNullGroup;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CardInfoDto extends BaseDto {
    //    @NotNull(groups = NotNullGroup.class, message = "cardInfo.id.isNull")
    private Long id;
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
