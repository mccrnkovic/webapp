package hr.tvz.crnkovic.hardwareapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/")
public class Controller {

    private HardwareServiceImpl hardwareService;
    private ReviewServiceImpl reviewService;

    @Autowired
    public Controller(HardwareServiceImpl hardwareService, ReviewServiceImpl reviewService) {
        this.hardwareService = hardwareService;
        this.reviewService = reviewService;
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

    /*@GetMapping("review")
    public List<ReviewDTO> findAllReviews(){
        return reviewService.findAll();
    }*/

    @GetMapping("review")
    public List<ReviewDTO> findReviewsByHardwareCode(@RequestParam String code){
        return reviewService.findAllByHardwareCode(code);
    }

    @PostMapping("hardware")
    public ResponseEntity<HardwareDTO> save(@Valid @RequestBody HardwareCommand command){
        return hardwareService.save(command)
                .map( hardwareDTO -> ResponseEntity.status(HttpStatus.ACCEPTED).body(hardwareDTO)
                )
                .orElseGet( () -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("hardware/{code}")
    public void delete(@PathVariable String code){
        reviewService.removeByHardwareCode(code);
        hardwareService.remove(code);
    }

}
