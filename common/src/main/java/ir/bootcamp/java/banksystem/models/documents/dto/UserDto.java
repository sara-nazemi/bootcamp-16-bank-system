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
public class UserDto extends BaseDto {
//    @NotNull(groups = NotNullGroup.class, message = "user.id.isNull")
    private Long id;
    @Pattern(regexp = "^[\\w]+$")
    private String email;
    @NotNull(groups = NotNullGroup.class, message = "user.telephone.isNull")
    @Pattern(regexp = "^[\\d&[^\\s]]+$")
    //@JsonProperty(value = "tell")
    private String telephone;
    //@NotNull(groups = NotNullGroup.class, message = "user.personId.isNull")
    private Long personId;
    //@NotNull(groups = NotNullGroup.class, message = "person.name.isnull")
    //@Size(min = 5, max = 20, message = "person.name.size.max")
    private String personName;
    //@NotNull(groups = NotNullGroup.class, message = "person.family.isnull")
    //@Pattern(regexp = "^[\\w|\\s]+$", message = "person.family.is.not.valid")
    private String personFamily;

    private String username;
    private String password;
}
