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
public class PersonDto extends BaseDto {
//    @NotNull(groups = NotNullGroup.class, message = "person.id.isNull")
    private Long id;
    @NotNull(groups = NotNullGroup.class, message = "person.userId.isNull")
    private Long userId;
    private Integer userVersion;
    @Size( min = 5, max = 20, message = "person.name.size.max")
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
