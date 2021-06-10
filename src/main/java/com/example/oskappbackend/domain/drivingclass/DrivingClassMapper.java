package com.example.oskappbackend.domain.drivingclass;

import com.example.oskappbackend.domain.course.Course;
import com.example.oskappbackend.domain.customer.Customer;
import com.example.oskappbackend.domain.instructor.Instructor;

public class DrivingClassMapper {

    public static DrivingClass from(DrivingClassDTO drivingClassDTO) {
        return DrivingClass.builder()
                .startTime(drivingClassDTO.getStartTime())
                .course(Course.builder().id(drivingClassDTO.getCourseId()).build())
                .customer(Customer.builder().id(drivingClassDTO.getCustomerId()).build())
                .instructor(Instructor.builder().id(drivingClassDTO.getInstructorId()).build())
                .build();
    }

}
