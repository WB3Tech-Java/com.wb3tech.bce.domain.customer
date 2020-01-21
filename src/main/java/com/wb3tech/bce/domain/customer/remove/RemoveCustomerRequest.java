package com.wb3tech.bce.domain.customer.remove;

import com.wb3tech.kernel.boundary.Request;

import java.util.UUID;

public class RemoveCustomerRequest implements Request {

    private final UUID id;

    public RemoveCustomerRequest(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return UUID.fromString(this.id.toString());
    }

}
