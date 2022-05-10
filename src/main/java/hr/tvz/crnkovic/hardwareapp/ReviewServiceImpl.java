package hr.tvz.crnkovic.hardwareapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
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
    public List<ReviewDTO> findAllByHardwareCode(String code) {
        return reviewRepository.findAllByHardwareCode(code)
                .stream().map(review -> review.DTO())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ReviewDTO> findById(Integer id) {
        return Optional.of(reviewRepository.findById(id)
                .get().DTO());
    }

    @Transactional
    public void removeByHardwareCode(String code) {
        reviewRepository.deleteAllByHardwareCode(code);
    }
}
