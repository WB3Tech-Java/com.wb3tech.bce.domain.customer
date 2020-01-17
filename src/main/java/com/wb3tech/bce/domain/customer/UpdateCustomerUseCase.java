package com.wb3tech.bce.domain.customer;

import com.wb3tech.kernel.UseCase;

class UpdateCustomerUseCase implements UseCase {

    private CustomerRequest request;
    private CustomerGateway gateway;

    UpdateCustomerUseCase(CustomerRequest request, CustomerGateway gateway) {
        this.request = request;
        this.gateway = gateway;
    }

    public void execute() {
        var customer = new Customer(this.request);
        this.gateway.Update(customer);
    }
}
