package hr.tvz.crnkovic.hardwareapp;

public class ReviewDTO {

    private Integer id;
    private String title;
    private String text;

    public ReviewDTO(Integer id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public Integer getId() {
        return id;
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

