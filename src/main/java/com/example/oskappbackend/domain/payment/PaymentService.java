package com.example.oskappbackend.domain.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Optional<Payment> updatePayment(Long id, Payment payment) {
        return Optional.of(paymentRepository.existsById(id))
                .filter(Boolean.TRUE::equals)
                .map(ifExist -> paymentRepository.save(payment));
    }

    public void deletePaymentById(Long id) {
        paymentRepository.deleteById(id);
    }

}
