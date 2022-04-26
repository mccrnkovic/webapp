package hr.tvz.crnkovic.hardwareapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HardwareServiceImpl implements HardwareService {

    private HardwareRepositoryImpl hardwareRepository;
    private JdbcHardwareRepository jdbcHardwareRepository;

    @Autowired
    public HardwareServiceImpl(HardwareRepositoryImpl hardwareRepository,
                               JdbcHardwareRepository jdbcHardwareRepository) {
        this.hardwareRepository = hardwareRepository;
        this.jdbcHardwareRepository = jdbcHardwareRepository;
    }

    @Override
    public List<HardwareDTO> findAll() {
        return jdbcHardwareRepository.findAll()
                .stream().map(hardware -> hardware.DTO())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<HardwareDTO> findByCode(String code) {
        Hardware hardware = hardwareRepository.findByCode(code).get();
        HardwareDTO hardwareDTO = new HardwareDTO(hardware.getName(), hardware.getPrice(), hardware.getCode());
        return Optional.of(this.jdbcHardwareRepository.findByCode(code).get().DTO());
    }

    @Override
    public Optional<HardwareDTO> save(HardwareCommand command) {
        Hardware hardware = new Hardware(command.getName(), command.getCode(), command.getPrice(),
                command.getAmount(), command.getType());
        /*if(!hardwareRepository.findAll().contains(hardware)){
            return Optional.of(hardwareRepository.save(hardware).DTO());
        }*/
        return Optional.of(this.jdbcHardwareRepository.save(hardware).DTO());
    }

    @Override
    public void remove(String code) {
        hardwareRepository.remove(code);
    }
}
