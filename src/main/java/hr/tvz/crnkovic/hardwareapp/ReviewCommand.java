package hr.tvz.crnkovic.hardwareapp;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ReviewCommand {

    @NotNull(message = "Review must have an ID")
    private Integer id;

    private String title;

    @NotBlank(message = "Review must have text")
    private String text;

    @Max(5)
    @Min(1)
    private Integer rating;

}
