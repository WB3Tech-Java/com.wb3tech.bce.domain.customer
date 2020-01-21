package com.wb3tech.bce.domain.customer.update;

import com.wb3tech.bce.domain.customer.CustomerEntity;

import java.util.UUID;

public class CustomerUpdatedEvent {

    private final UUID id;
    private final String firstName;
    private final String lastName;

    CustomerUpdatedEvent(UUID id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static CustomerUpdatedEvent Of(CustomerEntity entity) {
        return new CustomerUpdatedEvent(entity.getId().value(), entity.getFirstName(), entity.getLastName());
    }

    public UUID getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
}
