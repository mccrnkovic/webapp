package hr.tvz.crnkovic.hardwareapp;

import java.util.List;
import java.util.Optional;

public interface HardwareService {
    List<HardwareDTO> findAll();
    Optional<HardwareDTO> findByCode(String code);
    Optional<HardwareDTO> save(HardwareCommand command);
    void remove(String code);
}
