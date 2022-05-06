package hr.tvz.crnkovic.hardwareapp;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<ReviewDTO> findAll();
    Optional<ReviewDTO> findById(Integer id);
}
