package com.wb3tech.bce.domain.customer.remove;

import com.wb3tech.bce.domain.customer.CustomerEntity;

import java.util.UUID;

public class CustomerRemovedEvent {

    private final UUID id;

    CustomerRemovedEvent(UUID id) {
        this.id = id;
    }

    public static CustomerRemovedEvent of(CustomerEntity entity) {
        return new CustomerRemovedEvent(entity.getId().value());
    }

    public UUID getId() {
        return UUID.fromString(this.id.toString());
    }

}
