package hr.tvz.crnkovic.hardwareapp;

import org.springframework.context.annotation.Primary;

import javax.validation.constraints.*;

public class HardwareCommand {

    @NotBlank(message = "Hardware must have a name")
    private String name;

    @NotBlank(message = "Hardware must have a code")
    private String code;

    @Positive(message = "Price must be more than 0.0")
    private Double price;

    @NotNull(message = "Hardware type must be specified")
    private Hardware.HardwareType type;

    @PositiveOrZero(message = "Amount can't be below 0")
    private Integer amount;

    public HardwareCommand(String name, String code, Double price, Hardware.HardwareType type, Integer amount) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.type = type;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Double getPrice() {
        return price;
    }

    public Hardware.HardwareType getType() {
        return type;
    }

    public Integer getAmount() {
        return amount;
    }
}
