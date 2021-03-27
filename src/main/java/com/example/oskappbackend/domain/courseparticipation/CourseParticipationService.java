package com.example.oskappbackend.domain.courseparticipation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
