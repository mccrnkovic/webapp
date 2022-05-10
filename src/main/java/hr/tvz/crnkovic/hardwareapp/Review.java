package hr.tvz.crnkovic.hardwareapp;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "review")
public class Review {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="title")
    private String title;

    @Column(name="text")
    private String text;

    @Column(name="rating")
    private Integer rating;

    @ManyToOne
    @JoinColumn(name="hardware_code")
    private Hardware hardware;

    public Review(Integer id, String title, String text, Integer rating) {
        this.id = id;
        this.title = title;
        this.text = text;
        if (rating<1 || rating>5){
            this.rating = rating;
        }
        else {
            this.rating=-1;
        }
    }

    public Review() {

    }

    public ReviewDTO DTO() {
        return new ReviewDTO(this.title, this.text, this.rating);
    }
}
