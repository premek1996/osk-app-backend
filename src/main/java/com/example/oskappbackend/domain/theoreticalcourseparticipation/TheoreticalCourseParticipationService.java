package com.example.oskappbackend.domain.theoreticalcourseparticipation;

import com.example.oskappbackend.domain.theoreticalcourse.TheoreticalCourse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TheoreticalCourseParticipationService {

    private final TheoreticalCourseParticipationRepository theoreticalCourseParticipationRepository;

    public List<TheoreticalCourseParticipation> getAllTheoreticalCourseParticipation() {
        return theoreticalCourseParticipationRepository.findAll();
    }

    public Optional<TheoreticalCourseParticipation> getTheoreticalCourseParticipationById(Long id) {
        return theoreticalCourseParticipationRepository.findById(id);
    }

    public List<TheoreticalCourse> getTheoreticalCoursesByCustomerId(Long customerId) {
        return theoreticalCourseParticipationRepository.findAll()
                .stream()
                .filter(theoreticalCourseParticipation -> theoreticalCourseParticipation.getCustomer().getId().equals(customerId))
                .map(TheoreticalCourseParticipation::getTheoreticalCourse)
                .collect(Collectors.toList());
    }

    public TheoreticalCourseParticipation createTheoreticalCourseParticipation(TheoreticalCourseParticipation theoreticalCourseParticipation) {
        return theoreticalCourseParticipationRepository.save(theoreticalCourseParticipation);
    }

    public Optional<TheoreticalCourseParticipation> updateTheoreticalCourseParticipation(Long id, TheoreticalCourseParticipation theoreticalCourseParticipation) {
        return Optional.of(theoreticalCourseParticipationRepository.existsById(id))
                .filter(Boolean.TRUE::equals)
                .map(ifExist -> theoreticalCourseParticipationRepository.save(theoreticalCourseParticipation));
    }

    public void deleteTheoreticalCourseParticipationById(Long id) {
        theoreticalCourseParticipationRepository.deleteById(id);
    }

}
