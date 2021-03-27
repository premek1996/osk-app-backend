package com.example.oskappbackend.domain.course;

import com.example.oskappbackend.domain.courseparticipation.CourseParticipation;
import com.example.oskappbackend.domain.drivingclass.DrivingClass;
import com.example.oskappbackend.domain.payment.Payment;
import com.example.oskappbackend.domain.theoreticalcourse.TheoreticalCourse;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String description;

    private int theoreticalHours;

    private int practicalHours;

    @JsonManagedReference
    @OneToMany(mappedBy = "course")
    private Set<Payment> payments;

    @JsonManagedReference
    @OneToMany(mappedBy = "course")
    private Set<CourseParticipation> courseParticipation;

    @JsonManagedReference
    @OneToMany(mappedBy = "course")
    private Set<TheoreticalCourse> theoreticalCourses;

    @JsonManagedReference
    @OneToMany(mappedBy = "course")
    private Set<DrivingClass> drivingClasses;

}
