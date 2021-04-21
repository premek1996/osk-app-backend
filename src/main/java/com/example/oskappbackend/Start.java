package com.example.oskappbackend;

import com.example.oskappbackend.domain.course.Category;
import com.example.oskappbackend.domain.course.Course;
import com.example.oskappbackend.domain.course.CourseService;
import com.example.oskappbackend.domain.courseparticipation.CourseParticipation;
import com.example.oskappbackend.domain.courseparticipation.CourseParticipationService;
import com.example.oskappbackend.domain.customer.Customer;
import com.example.oskappbackend.domain.customer.CustomerService;
import com.example.oskappbackend.domain.drivingclass.DrivingClass;
import com.example.oskappbackend.domain.drivingclass.DrivingClassService;
import com.example.oskappbackend.domain.drivingclass.Location;
import com.example.oskappbackend.domain.instructor.Instructor;
import com.example.oskappbackend.domain.instructor.InstructorService;
import com.example.oskappbackend.domain.payment.Payment;
import com.example.oskappbackend.domain.payment.PaymentService;
import com.example.oskappbackend.domain.theoreticalclass.TheoreticalClass;
import com.example.oskappbackend.domain.theoreticalclass.TheoreticalClassService;
import com.example.oskappbackend.domain.theoreticalcourse.TheoreticalCourse;
import com.example.oskappbackend.domain.theoreticalcourse.TheoreticalCourseService;
import com.example.oskappbackend.domain.theoreticalcourseparticipation.TheoreticalCourseParticipation;
import com.example.oskappbackend.domain.theoreticalcourseparticipation.TheoreticalCourseParticipationService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Start {

    private final CourseService courseService;
    private final InstructorService instructorService;
    private final CustomerService customerService;
    private final PaymentService paymentService;
    private final TheoreticalCourseService theoreticalCourseService;
    private final TheoreticalClassService theoreticalClassService;
    private final DrivingClassService drivingClassService;
    private final TheoreticalCourseParticipationService theoreticalCourseParticipationService;
    private final CourseParticipationService courseParticipationService;

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        Course course = Course.builder()
                .name("name")
                .category(Category.B)
                .description("description")
                .price(1800)
                .practicalHours(42)
                .theoreticalHours(23)
                .build();
        courseService.createCourse(course);

        Instructor instructor = Instructor.builder()
                .mail("mail")
                .build();
        instructorService.createInstructor(instructor);

        Customer customer = Customer.builder()
                .mail("mail")
                .build();
        customerService.createCustomer(customer);

        Payment payment = Payment.builder()
                .amount(1800)
                .providerKey("34fdas32")
                .course(course)
                .customer(customer)
                .dateTime(LocalDateTime.now())
                .build();
        paymentService.createPayment(payment);

        CourseParticipation courseParticipation = CourseParticipation.builder()
                .course(course)
                .customer(customer)
                .build();

        courseParticipationService.createCourseParticipation(courseParticipation);

        TheoreticalCourse theoreticalCourse = TheoreticalCourse.builder()
                .course(course)
                .instructor(instructor)
                .maxCustomers(23)
                .startDate(LocalDate.now())
                .build();
        theoreticalCourseService.createTheoreticalCourse(theoreticalCourse);

        TheoreticalClass theoreticalClass = TheoreticalClass.builder()
                .theoreticalCourse(theoreticalCourse)
                .startTime(LocalDateTime.now())
                .endTime(LocalDateTime.now())
                .build();
        theoreticalClassService.createTheoreticalClass(theoreticalClass);

        List<Location> locations = List.of(new Location(44.087585, 44.087585), new Location(44.087585, 44.087585));

        DrivingClass drivingClass = DrivingClass.builder()
                .course(course)
                .customer(customer)
                .instructor(instructor)
                .startTime(LocalDateTime.now())
                .endTime(LocalDateTime.now())
                .locations(locations)
                .build();
        drivingClassService.createDrivingClass(drivingClass);

        TheoreticalCourseParticipation theoreticalCourseParticipation = TheoreticalCourseParticipation.builder()
                .customer(customer)
                .theoreticalCourse(theoreticalCourse)
                .build();
        theoreticalCourseParticipationService.createTheoreticalCourseParticipation(theoreticalCourseParticipation);

    }

}
