package com.example.oskappbackend.domain.drivingclass;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DrivingClassService {

    private final DrivingClassRepository drivingClassRepository;

    public List<DrivingClass> getAllDrivingClasses() {
        return drivingClassRepository.findAll();
    }

    public Optional<DrivingClass> getDrivingClassById(Long id) {
        return drivingClassRepository.findById(id);
    }

    public List<DrivingClass> getDrivingClassesByCourseIdAndCustomerId(Long courseId,
                                                                       Long customerId) {
        return drivingClassRepository.findAll()
                .stream()
                .filter(drivingClass -> drivingClass.getCourse().getId().equals(courseId) &&
                        drivingClass.getCustomer().getId().equals(customerId))
                .collect(Collectors.toList());
    }


    public DrivingClass createDrivingClass(DrivingClass drivingClass) {
        return drivingClassRepository.save(drivingClass);
    }

    public Optional<DrivingClass> updateDrivingClass(Long id, DrivingClass drivingClass) {
        return Optional.of(drivingClassRepository.existsById(id))
                .filter(Boolean.TRUE::equals)
                .map(ifExist -> drivingClassRepository.save(drivingClass));
    }

    public void deleteDrivingClassById(Long id) {
        drivingClassRepository.deleteById(id);
    }

}
