package hr.tvz.crnkovic.hardwareapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HardwareServiceImpl implements HardwareService {

    private HardwareRepositoryImpl hardwareRepository;

    @Autowired
    public HardwareServiceImpl(HardwareRepositoryImpl hardwareRepository) {
        this.hardwareRepository = hardwareRepository;
    }

    @Override
    public List<HardwareDTO> findAll() {
        return hardwareRepository.findAll().stream()
                .map(hardware -> new HardwareDTO(hardware.getName(), hardware.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public HardwareDTO findByCode(String code) {
        Hardware hardware = hardwareRepository.findByCode(code).get();
        return new HardwareDTO(hardware.getName(), hardware.getPrice());
    }
}
