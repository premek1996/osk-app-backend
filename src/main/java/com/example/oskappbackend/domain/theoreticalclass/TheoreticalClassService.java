package com.example.oskappbackend.domain.theoreticalclass;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TheoreticalClassService {

    private final TheoreticalClassRepository theoreticalClassRepository;

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

}
