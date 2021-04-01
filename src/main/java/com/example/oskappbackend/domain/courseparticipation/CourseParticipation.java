package com.example.oskappbackend.domain.courseparticipation;

import com.example.oskappbackend.domain.course.Course;
import com.example.oskappbackend.domain.customer.Customer;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "course_participation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CourseParticipation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    private Course course;

    @JsonIgnore
    @ManyToOne
    private Customer customer;

}
