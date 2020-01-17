package com.wb3tech.bce.domain.customer.update;

import com.wb3tech.bce.domain.customer.Customer;
import com.wb3tech.bce.domain.customer.CustomerRequest;
import com.wb3tech.kernel.UseCase;

class UpdateCustomerUseCase implements UseCase {

    private final CustomerRequest request;
    private Customer customer;

    UpdateCustomerUseCase(CustomerRequest request) {
        this.request = request;
    }

    public void execute() {
        this.customer = Customer.Of(this.request);
    }

    public Customer getCustomer() {
        return this.customer;
    }

}
