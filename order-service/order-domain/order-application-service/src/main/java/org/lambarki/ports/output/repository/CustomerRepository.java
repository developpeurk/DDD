package org.lambarki.ports.output.repository;

import org.lambarki.domain.entity.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {

  Optional<Customer> findCustomer(UUID customerId);
}
