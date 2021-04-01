package com.example.oskappbackend.domain.theoreticalclass;

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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "theoretical_classes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TheoreticalClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @JsonIgnore
    @ManyToOne
    private TheoreticalCourse theoreticalCourse;

}
