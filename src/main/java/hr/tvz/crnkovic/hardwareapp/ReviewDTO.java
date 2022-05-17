package hr.tvz.crnkovic.hardwareapp;

public class ReviewDTO {

    private String title;
    private String text;
    private Integer rating;
    private String hardwareCode;

    public ReviewDTO(String title, String text, Integer rating, String hardwareCode) {
        this.title = title;
        this.text = text;
        this.rating = rating;
        this.hardwareCode = hardwareCode;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

