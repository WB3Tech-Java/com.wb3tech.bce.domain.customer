package com.wb3tech.bce.domain.customer.create;

import com.wb3tech.bce.domain.customer.Customer;
import com.wb3tech.bce.domain.customer.CustomerGateway;
import com.wb3tech.kernel.conroller.CommandUseCase;

public class CreateCustomerUseCase implements CommandUseCase<CreateCustomerRequest> {

    private CustomerGateway gateway;
    private CustomerCreatedEventDispatcher eventDispatcher;

    public CreateCustomerUseCase(CustomerGateway gateway, CustomerCreatedEventDispatcher eventDispatcher) {
        this.gateway = gateway;
        this.eventDispatcher = eventDispatcher;
    }

    public void execute(CreateCustomerRequest request) {
        var customer = Customer.of(request.getFirstName(), request.getLastName());
        this.gateway.Create(customer);
        this.eventDispatcher.Dispatch(CustomerCreatedEvent.of(customer));
        request.setId(customer.getId().value());
    }

}
