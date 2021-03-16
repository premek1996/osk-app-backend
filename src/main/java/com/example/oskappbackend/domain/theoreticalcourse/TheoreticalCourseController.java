package com.example.oskappbackend.domain.theoreticalcourse;

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
@RequestMapping("/theoretical-courses")
@RequiredArgsConstructor
public class TheoreticalCourseController {

    private final TheoreticalCourseService theoreticalCourseService;
    private static final String THEORETICAL_COURSE_NOT_FOUND = "Theoretical course not found";

    @GetMapping
    public List<TheoreticalCourse> getAllTheoreticalCourses() {
        return theoreticalCourseService.getAllTheoreticalCourses();
    }

    @GetMapping("/{id}")
    public TheoreticalCourse getTheoreticalCourseById(@PathVariable Long id) {
        return theoreticalCourseService.getTheoreticalCourseById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, THEORETICAL_COURSE_NOT_FOUND));
    }

    @PostMapping
    public TheoreticalCourse createTheoreticalCourse(@RequestBody TheoreticalCourse theoreticalCourse) {
        return theoreticalCourseService.createTheoreticalCourse(theoreticalCourse);
    }

    @PutMapping("/{id}")
    public TheoreticalCourse updateTheoreticalCourse(@PathVariable Long id,
                                                     @RequestBody TheoreticalCourse theoreticalCourse) {
        return theoreticalCourseService.updateTheoreticalCourse(id, theoreticalCourse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, THEORETICAL_COURSE_NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public void deleteTheoreticalCourseById(@PathVariable long id) {
        theoreticalCourseService.deleteTheoreticalCourseById(id);
    }

}
