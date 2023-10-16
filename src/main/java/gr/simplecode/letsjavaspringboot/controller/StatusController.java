package gr.simplecode.letsjavaspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import gr.simplecode.letsjavaspringboot.model.StatusEntity;
import gr.simplecode.letsjavaspringboot.repository.StatusRepository;

@RestController
@RequestMapping("/status")
public class StatusController {
    private final StatusRepository statusRepository;

    @Autowired
    public StatusController(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @RequestMapping("/check")
    public ResponseEntity<String> checkStatus() {
        try {
            StatusEntity sampleStatus = new StatusEntity();
            statusRepository.save(sampleStatus);

            long count = statusRepository.count();

            if (count >= 0) {
                return new ResponseEntity<>("Database connection is working. Status checks : " + count, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Database connection is not working", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Database connection is not working", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
