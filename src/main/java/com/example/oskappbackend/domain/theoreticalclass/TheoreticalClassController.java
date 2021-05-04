package com.example.oskappbackend.domain.theoreticalclass;

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
import java.util.Set;

@RestController
@RequestMapping("/theoretical-classes")
@RequiredArgsConstructor
public class TheoreticalClassController {

    private final TheoreticalClassService theoreticalClassService;
    private static final String THEORETICAL_CLASS_NOT_FOUND = "Theoretical class not found";

    @GetMapping
    public List<TheoreticalClass> getAllTheoreticalClasses() {
        return theoreticalClassService.getAllTheoreticalClasses();
    }

    @GetMapping("/{id}")
    public TheoreticalClass getTheoreticalClassById(@PathVariable Long id) {
        return theoreticalClassService.getTheoreticalClassById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, THEORETICAL_CLASS_NOT_FOUND));
    }

    @PostMapping
    public TheoreticalClass createTheoreticalClass(@RequestBody TheoreticalClass theoreticalClass) {
        return theoreticalClassService.createTheoreticalClass(theoreticalClass);
    }

    @PutMapping("/{id}")
    public TheoreticalClass updateTheoreticalClass(@PathVariable Long id,
                                                   @RequestBody TheoreticalClass theoreticalClass) {
        return theoreticalClassService.updateTheoreticalClass(id, theoreticalClass)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, THEORETICAL_CLASS_NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public void deleteTheoreticalClassById(@PathVariable long id) {
        theoreticalClassService.deleteTheoreticalClassById(id);
    }

    @GetMapping("/courseId/{courseId}")
    public List<TheoreticalClass> getAvailableTheoreticalCoursesByCourseId(@PathVariable Long courseId) {
        return theoreticalClassService.getTheoreticalCoursesClassesByCourseId(courseId);
    }

}
