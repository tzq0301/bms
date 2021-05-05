package cn.tzq0301.bms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
public class Book implements Serializable {
    private static final long serialVersionUID = 8839466094153638322L;

    @NotNull
    @NotBlank
    private String bookId;

    @NotNull
    @NotBlank
    private String title;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^\\d{3}-\\d-\\d{3}-\\d{5}-\\d$")
    private String isbn;

    @NotNull
    @NotBlank
    private String author;

    @NotNull
    @NotBlank
    private String publisher;

    @NotNull
    @PositiveOrZero
    private int totalAmount;

    @NotNull
    @PositiveOrZero
    private int leftAmount;

    @NotNull
    private BigDecimal price;
}
