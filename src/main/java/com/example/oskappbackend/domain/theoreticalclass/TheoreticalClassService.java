package com.example.oskappbackend.domain.theoreticalclass;

import com.example.oskappbackend.domain.theoreticalcourse.TheoreticalCourse;
import com.example.oskappbackend.domain.theoreticalcourse.TheoreticalCourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TheoreticalClassService {

    private final TheoreticalClassRepository theoreticalClassRepository;
    private final TheoreticalCourseRepository theoreticalCourseRepository;

    public List<TheoreticalClass> getAllTheoreticalClasses() {
        return theoreticalClassRepository.findAll();
    }

    public Optional<TheoreticalClass> getTheoreticalClassById(Long id) {
        return theoreticalClassRepository.findById(id);
    }

    public TheoreticalClass createTheoreticalClass(TheoreticalClass theoreticalClass) {
        return theoreticalClassRepository.save(theoreticalClass);
    }

    public Optional<TheoreticalClass> updateTheoreticalClass(Long id, TheoreticalClass theoreticalClass) {
        return Optional.of(theoreticalClassRepository.existsById(id))
                .filter(Boolean.TRUE::equals)
                .map(ifExist -> theoreticalClassRepository.save(theoreticalClass));
    }

    public void deleteTheoreticalClassById(Long id) {
        theoreticalClassRepository.deleteById(id);
    }

    public List<TheoreticalClass> getTheoreticalCoursesClassesByCourseId(Long courseId) {
        List<TheoreticalClass> l = new ArrayList<>();
        for (TheoreticalClass theoreticalClass : theoreticalClassRepository.findAll()) {
            if (theoreticalClass.getTheoreticalCourse().getId().equals(courseId)) {
                l.add(theoreticalClass);
            }
        }
        return l;
    }
}
