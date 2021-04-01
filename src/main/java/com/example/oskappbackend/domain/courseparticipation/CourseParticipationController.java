package com.example.oskappbackend.domain.courseparticipation;

import com.example.oskappbackend.domain.course.Course;
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
@RequestMapping("/course-participation")
@RequiredArgsConstructor
public class CourseParticipationController {

    private final CourseParticipationService courseParticipationService;
    private static final String COURSE_PARTICIPATION_NOT_FOUND = "Course participation not found";

    @GetMapping
    public List<CourseParticipation> getAllCourseParticipation() {
        return courseParticipationService.getAllCourseParticipation();
    }

    @GetMapping("/{id}")
    public CourseParticipation getCourseParticipationById(@PathVariable Long id) {
        return courseParticipationService.getCourseParticipationById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, COURSE_PARTICIPATION_NOT_FOUND));
    }

    @GetMapping("/{customerId}")
    public List<Course> getCoursesByCustomerId(@PathVariable Long customerId) {
        return courseParticipationService.getCoursesByCustomerId(customerId);
    }

    @PostMapping
    public CourseParticipation createCourseParticipation(@RequestBody CourseParticipation courseParticipation) {
        return courseParticipationService.createCourseParticipation(courseParticipation);
    }

    @PutMapping("/{id}")
    public CourseParticipation updateCourseParticipation(@PathVariable Long id,
                                                         @RequestBody CourseParticipation courseParticipation) {
        return courseParticipationService.updateCourseParticipation(id, courseParticipation)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, COURSE_PARTICIPATION_NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public void deleteCourseParticipationById(@PathVariable long id) {
        courseParticipationService.deleteCourseParticipationById(id);
    }

}
