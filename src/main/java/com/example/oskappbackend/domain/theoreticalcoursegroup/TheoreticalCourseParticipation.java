package com.example.oskappbackend.domain.theoreticalcoursegroup;

import com.example.oskappbackend.domain.customer.Customer;
import com.example.oskappbackend.domain.theoreticalcourse.TheoreticalCourse;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "theoretical_course_participation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TheoreticalCourseParticipation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne
    private TheoreticalCourse theoreticalCourse;

    @JsonBackReference
    @ManyToOne
    private Customer customer;

}
