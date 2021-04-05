package com.example.oskappbackend.domain.drivingclass;

import com.example.oskappbackend.domain.course.Course;
import com.example.oskappbackend.domain.customer.Customer;
import com.example.oskappbackend.domain.instructor.Instructor;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "driving_classes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonStringType.class),
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class DrivingClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private List<Location> locations;

    @JsonIgnore
    @ManyToOne
    private Course course;

    @JsonBackReference
    @ManyToOne
    private Instructor instructor;

    @JsonIgnore
    @ManyToOne
    private Customer customer;

}
