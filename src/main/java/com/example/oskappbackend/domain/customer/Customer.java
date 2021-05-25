package com.example.oskappbackend.domain.customer;

import com.example.oskappbackend.domain.drivingclass.DrivingClass;
import com.example.oskappbackend.domain.payment.Payment;
import com.example.oskappbackend.domain.theoreticalcourseparticipation.TheoreticalCourseParticipation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

    @Column(unique = true)
    private String mail;

    private String firstName;

    private String secondName;

    private String phoneNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<Payment> payments;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<TheoreticalCourseParticipation> theoreticalCourseParticipation;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<DrivingClass> drivingClasses;

}
