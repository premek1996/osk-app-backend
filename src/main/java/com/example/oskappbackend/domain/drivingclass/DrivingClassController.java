package com.example.oskappbackend.domain.drivingclass;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/driving-classes")
@RequiredArgsConstructor
public class DrivingClassController {

    private final DrivingClassService paymentService;
    private static final String DRIVING_CLASS_NOT_FOUND = "Driving class not found";

    @GetMapping
    public List<DrivingClass> getAllDrivingClasses() {
        return paymentService.getAllDrivingClasses();
    }

    @GetMapping("/{id}")
    public DrivingClass getDrivingClassById(@PathVariable Long id) {
        return paymentService.getDrivingClassById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, DRIVING_CLASS_NOT_FOUND));
    }

    @PostMapping
    public DrivingClass createDrivingClass(@RequestBody DrivingClass payment) {
        return paymentService.createDrivingClass(payment);
    }

    @PutMapping("/{id}")
    public DrivingClass updateDrivingClass(@PathVariable Long id,
                                           @RequestBody DrivingClass payment) {
        return paymentService.updateDrivingClass(id, payment)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, DRIVING_CLASS_NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public void deleteDrivingClassById(@PathVariable long id) {
        paymentService.deleteDrivingClassById(id);
    }

}
