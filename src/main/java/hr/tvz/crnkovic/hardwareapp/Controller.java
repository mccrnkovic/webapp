package hr.tvz.crnkovic.hardwareapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<HardwareDTO> show(@PathVariable String code){
        return hardwareService.findByCode(code)
                .map(hardwareDTO -> ResponseEntity.status(HttpStatus.ACCEPTED).body(hardwareDTO))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<HardwareDTO> save(@Valid @RequestBody HardwareCommand command){
        return hardwareService.save(command)
                .map( hardwareDTO -> ResponseEntity.status(HttpStatus.CREATED).body(hardwareDTO)
                )
                .orElseGet( () -> ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @DeleteMapping("/all")
    public List<HardwareDTO> delete(@RequestParam String code){
        hardwareService.remove(code);
        return hardwareService.findAll();
    }

}
