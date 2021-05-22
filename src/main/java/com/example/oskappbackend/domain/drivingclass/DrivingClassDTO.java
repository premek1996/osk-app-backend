package com.example.oskappbackend.domain.drivingclass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DrivingClassDTO {

    private LocalDateTime startTime;
    private Long courseId;
    private Long instructorId;
    private Long customerId;

}
