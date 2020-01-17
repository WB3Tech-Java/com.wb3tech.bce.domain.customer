package com.wb3tech.bce.domain.customer.create;

import com.wb3tech.bce.domain.customer.CustomerRequest;

public class CreateCustomerRequest extends CustomerRequest {
    public CreateCustomerRequest(String firstName, String lastName) {
        super(firstName, lastName);
    }
}
