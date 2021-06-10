package com.example.oskappbackend.domain.drivingclass;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/driving-classes")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class DrivingClassController {

    private final DrivingClassService drivingClassService;
    private static final String DRIVING_CLASS_NOT_FOUND = "Driving class not found";

    @GetMapping
    public List<DrivingClass> getAllDrivingClasses() {
        return drivingClassService.getAllDrivingClasses();
    }

    @GetMapping("/{id}")
    public DrivingClass getDrivingClassById(@PathVariable Long id) {
        return drivingClassService.getDrivingClassById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, DRIVING_CLASS_NOT_FOUND));
    }

    @GetMapping("/{courseId}/{customerId}")
    public List<DrivingClass> getDrivingClassesByCourseIdAndCustomerId(@PathVariable Long courseId, @PathVariable Long customerId) {
        return drivingClassService.getDrivingClassesByCourseIdAndCustomerId(courseId, customerId);
    }

    @PostMapping
    public DrivingClass createDrivingClass(@RequestBody DrivingClassDTO drivingClassDTO) {
        return drivingClassService.createDrivingClass(DrivingClassMapper.from(drivingClassDTO));
    }

    @PostMapping("/{id}")
    public DrivingClass updateDrivingClass(@PathVariable Long id,
                                           @RequestBody List<Location> locations) {
        return drivingClassService.updateDrivingClass(id, locations)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, DRIVING_CLASS_NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public void deleteDrivingClassById(@PathVariable long id) {
        drivingClassService.deleteDrivingClassById(id);
    }

}
