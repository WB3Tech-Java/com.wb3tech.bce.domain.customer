package com.wb3tech.bce.domain.customer.find;

import com.wb3tech.bce.domain.customer.CustomerEntity;
import com.wb3tech.kernel.boundary.Response;
import com.wb3tech.kernel.entity.Identity;

import java.util.UUID;

public class FindCustomerResponse implements Response {

    private final UUID id;
    private final String firstName;
    private final String lastName;
    private boolean exists;

    FindCustomerResponse(UUID id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    static FindCustomerResponse of(CustomerEntity entity) {
        var customer = new FindCustomerResponse(entity.getId().value(), entity.getFirstName(), entity.getLastName());
        customer.setAsExists();
        return customer;
    }

    public static FindCustomerResponse DoesNotExist() {
        return new FindCustomerResponse(Identity.Default().value(), "", "");
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

    public boolean doesExist() { return this.exists; }

    private void setAsExists() {
        this.exists = true;
    }


}
