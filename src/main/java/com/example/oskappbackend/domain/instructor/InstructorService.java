package com.example.oskappbackend.domain.instructor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InstructorService {

    private final InstructorRepository instructorRepository;

    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    public Optional<Instructor> getInstructorById(Long id) {
        return instructorRepository.findById(id);
    }

    public Instructor createInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public Optional<Instructor> updateInstructor(Long id, Instructor instructor) {
        return Optional.of(instructorRepository.existsById(id))
                .filter(Boolean.TRUE::equals)
                .map(ifExist -> instructorRepository.save(instructor));
    }

    public void deleteInstructorById(Long id) {
        instructorRepository.deleteById(id);
    }

}
