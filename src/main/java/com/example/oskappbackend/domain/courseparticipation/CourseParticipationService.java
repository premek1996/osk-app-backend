package com.example.oskappbackend.domain.courseparticipation;

import com.example.oskappbackend.domain.course.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseParticipationService {

    private final CourseParticipationRepository courseParticipationRepository;

    public List<CourseParticipation> getAllCourseParticipation() {
        return courseParticipationRepository.findAll();
    }

    public Optional<CourseParticipation> getCourseParticipationById(Long id) {
        return courseParticipationRepository.findById(id);
    }

    public List<Course> getCoursesByCustomerId(Long customerId) {
        return courseParticipationRepository.findAll()
                .stream()
                .filter(courseParticipation -> courseParticipation.getCustomer().getId().equals(customerId))
                .map(CourseParticipation::getCourse)
                .collect(Collectors.toList());
    }

    public CourseParticipation createCourseParticipation(CourseParticipation courseParticipation) {
        return courseParticipationRepository.save(courseParticipation);
    }

    public Optional<CourseParticipation> updateCourseParticipation(Long id, CourseParticipation courseParticipation) {
        return Optional.of(courseParticipationRepository.existsById(id))
                .filter(Boolean.TRUE::equals)
                .map(ifExist -> courseParticipationRepository.save(courseParticipation));
    }

    public void deleteCourseParticipationById(Long id) {
        courseParticipationRepository.deleteById(id);
    }

}
