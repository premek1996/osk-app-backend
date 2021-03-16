package com.example.oskappbackend.domain.course;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Optional<Course> updateCourse(Long id, Course course) {
        return Optional.of(courseRepository.existsById(id))
                .filter(Boolean.TRUE::equals)
                .map(ifExist -> courseRepository.save(course));
    }

    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }

}
