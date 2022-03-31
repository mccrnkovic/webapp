package hr.tvz.crnkovic.hardwareapp;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class HardwareRepositoryImpl implements HardwareRepository{

    private List<Hardware> hardwareList;

    public HardwareRepositoryImpl() {
        this.hardwareList = List.of(new Hardware[]
                {new Hardware("slušalice", "0", 629.0, 11, Hardware.HardwareType.OTHER),
                new Hardware("motherboard", "1", 899.0, 8, Hardware.HardwareType.MBO)});
    }

    @Override
    public List<Hardware> findAll() {
        return this.hardwareList;
    }

    @Override
    public Optional<Hardware> findByCode(String code) {
        return hardwareList.stream().filter(hardware -> hardware.getCode().equals(code)).findFirst();
    }
}
