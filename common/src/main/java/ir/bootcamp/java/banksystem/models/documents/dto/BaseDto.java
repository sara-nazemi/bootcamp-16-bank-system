package ir.bootcamp.java.banksystem.models.documents.dto;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class BaseDto {
    private Date insertDate;
    private Date lastModifiedDate;
    @PositiveOrZero
    //این رو که بذاریم دیگه سمت client نشونش نمیده
//   @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer version;
    
}
