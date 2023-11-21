package ir.bootcamp.java.banksystem.models.documents.dto;

import ir.bootcamp.java.banksystem.models.documents.valid.NotNullGroup;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonDto extends BaseDto {
    private Long id;
    @NotNull(groups = NotNullGroup.class, message = "person.userId.isNull")
    private Long userId;
    private Integer userVersion;
    @Size(min = 5, max = 20, message = "person.name.size.max")
    @NotNull(groups = NotNullGroup.class, message = "person.name.isnull")
    private String name;
    @NotNull(groups = NotNullGroup.class, message = "person.family.isnull")
    @Pattern(regexp = "^[\\w|\\s]+$", message = "person.family.is.not.valid")
    private String family;
    @NotNull(groups = NotNullGroup.class, message = "person.nationalCode.isNull")
    @Size(min = 10, max = 10, message = "person.nationalCode.isNotValid")
    @Pattern(regexp = "^[\\d]+$", message = "person.nationalCode.isNotNumber")
    private String nationalCode;
    private String address;

}
