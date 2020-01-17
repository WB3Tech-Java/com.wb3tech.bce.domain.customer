package com.wb3tech.bce.domain.customer.update;

import com.wb3tech.bce.domain.customer.Customer;
import com.wb3tech.bce.domain.customer.CustomerGateway;
import com.wb3tech.bce.domain.customer.CustomerRequest;
import com.wb3tech.kernel.UseCase;

class UpdateCustomerUseCase implements UseCase {

    private CustomerRequest request;
    private CustomerGateway gateway;

    UpdateCustomerUseCase(CustomerRequest request, CustomerGateway gateway) {
        this.request = request;
        this.gateway = gateway;
    }

    public void execute() {
        var customer = Customer.Of(this.request);
        this.gateway.Update(customer);
    }
}
