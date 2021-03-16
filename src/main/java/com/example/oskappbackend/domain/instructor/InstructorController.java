package com.example.oskappbackend.domain.instructor;

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
@RequestMapping("/instructors")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;
    private static final String INSTRUCTOR_NOT_FOUND = "Instructor not found";

    @GetMapping
    public List<Instructor> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    @GetMapping("/{id}")
    public Instructor getInstructorById(@PathVariable Long id) {
        return instructorService.getInstructorById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, INSTRUCTOR_NOT_FOUND));
    }

    @PostMapping
    public Instructor createInstructor(@RequestBody Instructor instructor) {
        return instructorService.createInstructor(instructor);
    }

    @PutMapping("/{id}")
    public Instructor updateInstructor(@PathVariable Long id,
                                       @RequestBody Instructor instructor) {
        return instructorService.updateInstructor(id, instructor)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, INSTRUCTOR_NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public void deleteInstructorById(@PathVariable long id) {
        instructorService.deleteInstructorById(id);
    }

}
