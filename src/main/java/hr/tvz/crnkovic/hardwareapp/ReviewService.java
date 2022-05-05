package hr.tvz.crnkovic.hardwareapp;

import java.util.List;

public interface ReviewService {
    List<ReviewDTO> findAll();
    ReviewDTO findById(Integer id);
}
