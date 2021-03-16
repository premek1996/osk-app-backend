package com.example.oskappbackend.domain.theoreticalcourse;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TheoreticalCourseService {

    private final TheoreticalCourseRepository theoreticalCourseRepository;

    public List<TheoreticalCourse> getAllTheoreticalCourses() {
        return theoreticalCourseRepository.findAll();
    }

    public Optional<TheoreticalCourse> getTheoreticalCourseById(Long id) {
        return theoreticalCourseRepository.findById(id);
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
