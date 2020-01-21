package com.wb3tech.bce.domain.customer.create;

import com.wb3tech.bce.domain.customer.Customer;
import com.wb3tech.bce.domain.customer.CustomerGateway;
import com.wb3tech.kernel.conroller.CommandUseCase;

public class CreateCustomerUseCase implements CommandUseCase<CreateCustomerRequest> {

    private CustomerGateway gateway;

    public CreateCustomerUseCase(CustomerGateway gateway) {
        this.gateway = gateway;
    }

    public void execute(CreateCustomerRequest request) {
        var customer = Customer.Of(request.getFirstName(), request.getLastName());
        this.gateway.Create(customer);
        request.setId(customer.getId().value());
    }

}
