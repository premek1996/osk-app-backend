package com.example.oskappbackend.domain.instructor;

import com.example.oskappbackend.domain.drivingclass.DrivingClass;
import com.example.oskappbackend.domain.theoreticalcourse.TheoreticalCourse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "instructors")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mail;

    private String password;

    private String name;

    private String surname;

    private String phone;

    @JsonIgnore
    @OneToMany(mappedBy = "instructor")
    private Set<TheoreticalCourse> theoreticalCourses;

    @JsonIgnore
    @OneToMany(mappedBy = "instructor")
    private Set<DrivingClass> drivingClasses;

}
