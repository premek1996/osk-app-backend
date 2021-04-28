package com.example.oskappbackend.domain.theoreticalcourse;

import com.example.oskappbackend.domain.customer.Customer;
import com.example.oskappbackend.domain.customer.CustomerRepository;
import com.example.oskappbackend.domain.theoreticalcourseparticipation.TheoreticalCourseParticipation;
import com.example.oskappbackend.domain.theoreticalcourseparticipation.TheoreticalCourseParticipationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TheoreticalCourseService {

    private final TheoreticalCourseRepository theoreticalCourseRepository;
    private final TheoreticalCourseParticipationRepository theoreticalCourseParticipationRepository;
    private final CustomerRepository customerRepository;

    public List<TheoreticalCourse> getAllTheoreticalCourses() {
        return theoreticalCourseRepository.findAll();
    }

    public List<TheoreticalCourse> getTheoreticalCoursesByCourseId(Long courseId) {
        return theoreticalCourseRepository.findAll()
                .stream()
                .filter(theoreticalCourse -> theoreticalCourse.getCourse().getId().equals(courseId))
                .collect(Collectors.toList());
    }

    public List<TheoreticalCourse> getTheoreticalCoursesByCustomerId(Long customerId) {
        return theoreticalCourseParticipationRepository.findAll()
                .stream()
                .filter(theoreticalCourseParticipation -> theoreticalCourseParticipation.getCustomer().getId().equals(customerId))
                .map(TheoreticalCourseParticipation::getTheoreticalCourse)
                .collect(Collectors.toList());
    }

    public TheoreticalCourseParticipation enrollCustomerInTheoreticalCourse(Long customerId, Long theoreticalCourseId) {
        Customer customer = customerRepository.getOne(customerId);
        TheoreticalCourse theoreticalCourse = theoreticalCourseRepository.getOne(theoreticalCourseId);
        TheoreticalCourseParticipation theoreticalCourseParticipation = TheoreticalCourseParticipation.builder()
                .customer(customer)
                .theoreticalCourse(theoreticalCourse)
                .build();
        return theoreticalCourseParticipationRepository.save(theoreticalCourseParticipation);
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
