package hr.tvz.crnkovic.hardwareapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    @Override
    public Optional<HardwareDTO> save(HardwareCommand command) {
        Hardware hardware = new Hardware(command.getName(), command.getCode(), command.getPrice(),
                command.getAmount(), command.getType());
        if(!hardwareRepository.findAll().contains(hardware)){
            hardwareRepository.findAll().add(hardware);
            return Optional.of(hardware.DTO());
        }
        return null;
    }
}
