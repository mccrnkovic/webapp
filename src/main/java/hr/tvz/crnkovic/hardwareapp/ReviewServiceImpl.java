package hr.tvz.crnkovic.hardwareapp;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewServiceImpl implements ReviewService{

    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<ReviewDTO> findAll() {
        return reviewRepository.findAll()
                .stream().map(review -> review.DTO())
                .collect(Collectors.toList());
    }

    @Override
    public ReviewDTO findById(Integer id) {
        return reviewRepository.findById(id)
                .map(review -> review.DTO())
                .get();
    }
}
