package com.wb3tech.bce.domain.customer;

import com.wb3tech.kernel.boundary.Request;

import java.util.UUID;

public abstract class CustomerRequest implements Request {

    private UUID id;
    private String firstName;
    private String lastName;

    public CustomerRequest(String fistName, String lastName) {
        this.firstName = fistName;
        this.lastName = lastName;
    }

    public void setId(UUID id) {
        this.id = id;
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
