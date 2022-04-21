package hr.tvz.crnkovic.hardwareapp;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class HardwareRepositoryImpl implements HardwareRepository{

    private List<Hardware> hardwareList;

    public HardwareRepositoryImpl() {
//        this.hardwareList = List.of(new Hardware[]
//                {new Hardware("slušalice", "0", 629.0, 11, Hardware.HardwareType.OTHER),
//                new Hardware("motherboard", "1", 899.0, 8, Hardware.HardwareType.MBO),
//                        new Hardware("grafička", "2", 399.0, 2, Hardware.HardwareType.GPU)});

        this.hardwareList= new ArrayList<>();
        hardwareList.add(new Hardware("slušalice", "0",
                229.0, 11, Hardware.HardwareType.OTHER));
        hardwareList.add(new Hardware("motherboard", "1",
                899.0, 8, Hardware.HardwareType.MBO));
        hardwareList.add(new Hardware("grafička", "2",
                1399.0, 2, Hardware.HardwareType.GPU));
    }

    @Override
    public List<Hardware> findAll() {
        return this.hardwareList;
    }

    @Override
    public Optional<Hardware> findByCode(String code) {
        return hardwareList.stream().filter(hardware -> hardware.getCode().equals(code)).findFirst();
    }

    @Override
    public void remove(String code) {
        hardwareList.remove(hardwareList.stream()
                .filter(hardware -> hardware.getCode().equals(code))
                .findFirst().get());
    }
}
