package com.example.oskappbackend.domain.theoreticalcourse;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TheoreticalCourseService {

    private final TheoreticalCourseRepository theoreticalCourseRepository;

    public List<TheoreticalCourse> getAllTheoreticalCourses() {
        return theoreticalCourseRepository.findAll();
    }

    public List<TheoreticalCourse> getTheoreticalCoursesByCourseId(@PathVariable Long courseId) {
        return theoreticalCourseRepository.findAll()
                .stream()
                .filter(theoreticalCourse -> theoreticalCourse.getCourse().getId().equals(courseId))
                .collect(Collectors.toList());
    }

    public TheoreticalCourse createTheoreticalCourse(TheoreticalCourse theoreticalCourse) {
        return theoreticalCourseRepository.save(theoreticalCourse);
    }

    public Optional<TheoreticalCourse> updateTheoreticalCourse(Long id, TheoreticalCourse theoreticalCourse) {
        return Optional.of(theoreticalCourseRepository.existsById(id))
                .filter(Boolean.TRUE::equals)
                .map(ifExist -> theoreticalCourseRepository.save(theoreticalCourse));
    }

    public void deleteTheoreticalCourseById(Long id) {
        theoreticalCourseRepository.deleteById(id);
    }

}
