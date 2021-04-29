package com.example.oskappbackend;

import com.example.oskappbackend.domain.course.Category;
import com.example.oskappbackend.domain.course.Course;
import com.example.oskappbackend.domain.course.CourseService;
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

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        Course course = Course.builder()
                .name("Prawo jazdy kategorii B")
                .category(Category.B)
                .price(2200)
                .practicalHours(30)
                .theoreticalHours(30)
                .build();

        Course course2 = Course.builder()
                .name("Prawo jazdy kategorii B na automacie")
                .category(Category.B)
                .price(2000)
                .practicalHours(30)
                .theoreticalHours(30)
                .build();

        Course course3 = Course.builder()
                .name("Prawo jazdy kategorii E/B")
                .category(Category.B)
                .price(1400)
                .practicalHours(20)
                .theoreticalHours(20)
                .build();

        course = courseService.createCourse(course);
        course2 = courseService.createCourse(course2);
        course3 = courseService.createCourse(course3);

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

        TheoreticalCourse theoreticalCourse = TheoreticalCourse.builder()
                .course(course)
                .instructor(instructor)
                .customersMaxNumber(30)
                .startDate(LocalDate.now())
                .build();
        theoreticalCourseService.createTheoreticalCourse(theoreticalCourse);

        TheoreticalCourse theoreticalCourse2 = TheoreticalCourse.builder()
                .course(course)
                .instructor(instructor)
                .customersMaxNumber(23)
                .startDate(LocalDate.now().plusDays(10))
                .build();
        theoreticalCourseService.createTheoreticalCourse(theoreticalCourse2);

        TheoreticalCourse theoreticalCourse3 = TheoreticalCourse.builder()
                .course(course2)
                .instructor(instructor)
                .customersMaxNumber(23)
                .startDate(LocalDate.now().plusDays(20))
                .build();
        theoreticalCourseService.createTheoreticalCourse(theoreticalCourse3);

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


        DrivingClass drivingClass2 = DrivingClass.builder()
                .course(course)
                .customer(customer)
                .instructor(instructor)
                .startTime(LocalDateTime.now().plusDays(2))
                .endTime(LocalDateTime.now().plusDays(2))
                .locations(locations)
                .build();

        drivingClassService.createDrivingClass(drivingClass2);

        DrivingClass drivingClass3 = DrivingClass.builder()
                .course(course)
                .customer(customer)
                .instructor(instructor)
                .startTime(LocalDateTime.now().plusDays(4))
                .endTime(LocalDateTime.now().plusDays(4))
                .locations(locations)
                .build();

        drivingClassService.createDrivingClass(drivingClass3);

    }

}
