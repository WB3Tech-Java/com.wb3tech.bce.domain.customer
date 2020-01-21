package com.wb3tech.bce.domain.customer.find;

import com.wb3tech.kernel.boundary.Request;

import java.util.UUID;

public class FindCustomerRequest implements Request {

    private final UUID id;

    public FindCustomerRequest(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return UUID.fromString(this.id.toString());
    }

}
