package com.wb3tech.bce.domain.customer.create;

import com.wb3tech.bce.domain.customer.Customer;

import java.util.UUID;

public class CustomerCreatedEvent {

    private final UUID id;
    private final String firstName;
    private final String lastName;

    CustomerCreatedEvent(UUID id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static CustomerCreatedEvent of(Customer customer) {
        return new CustomerCreatedEvent(customer.getId().value(), customer.getFirstName(), customer.getLastName());
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
