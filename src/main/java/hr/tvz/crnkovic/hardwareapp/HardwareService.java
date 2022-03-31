package hr.tvz.crnkovic.hardwareapp;

import java.util.List;

public interface HardwareService {
    List<HardwareDTO> findAll();
    HardwareDTO findByCode(String code);
}
