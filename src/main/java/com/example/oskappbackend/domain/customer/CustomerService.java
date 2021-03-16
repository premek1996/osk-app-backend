package com.example.oskappbackend.domain.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> updateCustomer(Long id, Customer customer) {
        return Optional.of(customerRepository.existsById(id))
                .filter(Boolean.TRUE::equals)
                .map(ifExist -> customerRepository.save(customer));
    }

    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }

}
