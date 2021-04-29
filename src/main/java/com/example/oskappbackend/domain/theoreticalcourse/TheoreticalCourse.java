package com.example.oskappbackend.domain.theoreticalcourse;

import com.example.oskappbackend.domain.course.Course;
import com.example.oskappbackend.domain.instructor.Instructor;
import com.example.oskappbackend.domain.theoreticalclass.TheoreticalClass;
import com.example.oskappbackend.domain.theoreticalcourseparticipation.TheoreticalCourseParticipation;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "theoretical_courses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TheoreticalCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;

    private int customersMaxNumber;

    private int customersCurrentNumber;

    @JsonManagedReference
    @ManyToOne
    private Course course;

    @JsonManagedReference
    @ManyToOne
    private Instructor instructor;

    @JsonManagedReference
    @OneToMany(mappedBy = "theoreticalCourse")
    private Set<TheoreticalClass> theoreticalClasses;

    @JsonIgnore
    @OneToMany(mappedBy = "theoreticalCourse")
    private Set<TheoreticalCourseParticipation> theoreticalCourseParticipation;

    public void incrementCustomersCurrentNumber() {
        this.customersCurrentNumber++;
    }

    public boolean isAvailable() {
        return customersCurrentNumber < customersMaxNumber;
    }

}
