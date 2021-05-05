package cn.tzq0301.bms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author TZQ
 * @Description TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reader implements Serializable {
    private static final long serialVersionUID = 6081063390338545472L;

    @NotNull
    @NotBlank
    private String readerId;

    @NotNull
    @NotBlank
    private String name;

    @PositiveOrZero
    private int gender;

    @NotNull
    @NotBlank
    private String mobileNumber;

    @NotNull
    @NotBlank
    private String address;

    @NotNull
    private BigDecimal debt;
}
