package hr.tvz.crnkovic.hardwareapp;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<ReviewDTO> findAll();
    List<ReviewDTO> findAllByHardwareCode(String code);
    Optional<ReviewDTO> findById(Integer id);
}
