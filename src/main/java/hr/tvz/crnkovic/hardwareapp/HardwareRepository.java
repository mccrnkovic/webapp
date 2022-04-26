package hr.tvz.crnkovic.hardwareapp;


import java.util.List;
import java.util.Optional;

public interface HardwareRepository {

    List<Hardware> findAll();

    Optional<Hardware> findByCode(String code);

    void remove(String code);

    Hardware save(Hardware hardware);
}
