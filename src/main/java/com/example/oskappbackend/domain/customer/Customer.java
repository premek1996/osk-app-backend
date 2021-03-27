package com.example.oskappbackend.domain.customer;

import com.example.oskappbackend.domain.courseparticipation.CourseParticipation;
import com.example.oskappbackend.domain.drivingclass.DrivingClass;
import com.example.oskappbackend.domain.payment.Payment;
import com.example.oskappbackend.domain.theoreticalcourseparticipation.TheoreticalCourseParticipation;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mail;

    private String password;

    private String name;

    private String surname;

    private String phone;

    @JsonManagedReference
    @OneToMany(mappedBy = "customer")
    private Set<Payment> payments;

    @JsonManagedReference
    @OneToMany(mappedBy = "customer")
    private Set<CourseParticipation> courseParticipation;

    @JsonManagedReference
    @OneToMany(mappedBy = "customer")
    private Set<TheoreticalCourseParticipation> theoreticalCourseParticipation;


    @JsonManagedReference
    @OneToMany(mappedBy = "customer")
    private Set<DrivingClass> drivingClasses;

}
