package org.bank.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseDto {
    private Date insertDate;
    private Date lastModifiedDate;
    @PositiveOrZero
    //این رو که بذاریم دیگه سمت client نشونش نمیده
//   @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer version;
}
