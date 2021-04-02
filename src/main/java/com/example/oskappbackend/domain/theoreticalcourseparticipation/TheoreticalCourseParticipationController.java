package com.example.oskappbackend.domain.theoreticalcourseparticipation;

import com.example.oskappbackend.domain.theoreticalcourse.TheoreticalCourse;
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
@RequestMapping("/theoretical-course-participation")
@RequiredArgsConstructor
public class TheoreticalCourseParticipationController {

    private final TheoreticalCourseParticipationService theoreticalCourseParticipationService;
    private static final String THEORETICAL_COURSE_PARTICIPATION_NOT_FOUND = "Theoretical course participation not found";

    @GetMapping
    public List<TheoreticalCourseParticipation> getAllTheoreticalCourseParticipation() {
        return theoreticalCourseParticipationService.getAllTheoreticalCourseParticipation();
    }

    @GetMapping("/{id}")
    public TheoreticalCourseParticipation getTheoreticalCourseParticipationById(@PathVariable Long id) {
        return theoreticalCourseParticipationService.getTheoreticalCourseParticipationById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, THEORETICAL_COURSE_PARTICIPATION_NOT_FOUND));
    }

    @GetMapping("/{customerId}/{courseId}")
    public List<TheoreticalCourse> getTheoreticalCoursesByCustomerIdAndCourseId(@PathVariable Long customerId, @PathVariable Long courseId) {
        return theoreticalCourseParticipationService.getTheoreticalCoursesByCustomerIdAndCourseId(customerId, courseId);
    }

    @PostMapping
    public TheoreticalCourseParticipation createTheoreticalCourseParticipation(@RequestBody TheoreticalCourseParticipation theoreticalCourseParticipation) {
        return theoreticalCourseParticipationService.createTheoreticalCourseParticipation(theoreticalCourseParticipation);
    }

    @PutMapping("/{id}")
    public TheoreticalCourseParticipation updateTheoreticalCourseParticipation(@PathVariable Long id,
                                                                               @RequestBody TheoreticalCourseParticipation theoreticalCourseParticipation) {
        return theoreticalCourseParticipationService.updateTheoreticalCourseParticipation(id, theoreticalCourseParticipation)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, THEORETICAL_COURSE_PARTICIPATION_NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public void deleteTheoreticalCourseParticipationById(@PathVariable long id) {
        theoreticalCourseParticipationService.deleteTheoreticalCourseParticipationById(id);
    }

}
