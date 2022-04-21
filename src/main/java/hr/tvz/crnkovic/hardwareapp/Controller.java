package hr.tvz.crnkovic.hardwareapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/")
public class Controller {

    private HardwareServiceImpl hardwareService;

    @Autowired
    public Controller(HardwareServiceImpl hardwareService) {
        this.hardwareService = hardwareService;
    }

    @GetMapping("")
    public String showLink(){
        return "<a href=\"http://localhost:4200/\">Link</a>";
    }

    @GetMapping("hardware")
    public List<HardwareDTO> showAll(){
        return hardwareService.findAll();
    }

    @GetMapping("hardware/{code}")
    public ResponseEntity<HardwareDTO> show(@PathVariable String code){
        return hardwareService.findByCode(code)
                .map(hardwareDTO -> ResponseEntity.status(HttpStatus.OK).body(hardwareDTO))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<HardwareDTO> save(@Valid @RequestBody HardwareCommand command){
        return hardwareService.save(command)
                .map( hardwareDTO -> ResponseEntity.status(HttpStatus.CREATED).body(hardwareDTO)
                )
                .orElseGet( () -> ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{code}")
    public void delete(@PathVariable String code){
        hardwareService.remove(code);
    }

}
