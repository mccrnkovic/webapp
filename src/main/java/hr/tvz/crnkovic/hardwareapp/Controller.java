package hr.tvz.crnkovic.hardwareapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {

    private HardwareServiceImpl hardwareService;

    @Autowired
    public Controller(HardwareServiceImpl hardwareService) {
        this.hardwareService = hardwareService;
    }

    @GetMapping("all")
    public List<HardwareDTO> showAll(){
        return hardwareService.findAll();
    }

    @GetMapping("one")
    public HardwareDTO show(@RequestParam String code){
        return hardwareService.findByCode(code);
    }

}
