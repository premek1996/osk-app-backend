package com.example.oskappbackend.domain.drivingclass;

import com.example.oskappbackend.domain.course.Course;
import com.example.oskappbackend.domain.customer.Customer;
import com.example.oskappbackend.domain.instructor.Instructor;

import java.util.List;

public class DrivingClassMapper {

    public static DrivingClass from(DrivingClassDTO drivingClassDTO) {
        List<Location> locations = List.of(
                new Location(51.10926382422896, 17.061962513665772),
                new Location(51.11438225604232, 17.0605490562112),
                new Location(51.11628341568578, 17.055363031720777),
                new Location(51.12560832839537, 17.054337019704196));

        return DrivingClass.builder()
                .startTime(drivingClassDTO.getStartTime())
                .course(Course.builder().id(drivingClassDTO.getCourseId()).build())
                .customer(Customer.builder().id(drivingClassDTO.getCustomerId()).build())
                .instructor(Instructor.builder().id(drivingClassDTO.getInstructorId()).build())
                .locations(locations)
                .build();
    }

}
