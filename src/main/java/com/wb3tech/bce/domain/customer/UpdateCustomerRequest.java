package com.wb3tech.bce.domain.customer;

import java.util.UUID;

public class UpdateCustomerRequest extends CustomerRequest {
    public UpdateCustomerRequest(UUID id, String firstName, String lastName) {
        super(firstName, lastName);
        this.setId(id);
    }
}
