package com.wb3tech.bce.domain.customer.create;

import com.wb3tech.bce.domain.customer.Customer;
import com.wb3tech.bce.domain.customer.CustomerRequest;
import com.wb3tech.kernel.UseCase;

public class CreateCustomerUseCase implements UseCase {

    private CustomerRequest request;
    private Customer customer;

    CreateCustomerUseCase(CustomerRequest request) {
        this.request = request;
    }

    public void execute() {
        this.customer = Customer.Of(this.request.getFirstName(), this.request.getLastName());
        this.request.setId(customer.getId().value());
    }

    public Customer getCustomer() {
        return this.customer;
    }

}
