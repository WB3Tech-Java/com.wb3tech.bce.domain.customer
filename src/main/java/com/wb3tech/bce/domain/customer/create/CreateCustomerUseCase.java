package com.wb3tech.bce.domain.customer.create;

import com.wb3tech.bce.domain.customer.Customer;
import com.wb3tech.bce.domain.customer.CustomerGateway;
import com.wb3tech.bce.domain.customer.CustomerRequest;
import com.wb3tech.kernel.UseCase;

public class CreateCustomerUseCase implements UseCase {

    private CustomerRequest request;
    private CustomerGateway customerGateway;

    CreateCustomerUseCase(CustomerRequest request, CustomerGateway customerGateway) {
        this.request = request;
        this.customerGateway = customerGateway;
    }

    public void execute() {
        var customer = Customer.Of(this.request.getFirstName(), this.request.getLastName());
        this.customerGateway.Create(customer);
        this.request.setId(customer.getId().value());
    }

}
