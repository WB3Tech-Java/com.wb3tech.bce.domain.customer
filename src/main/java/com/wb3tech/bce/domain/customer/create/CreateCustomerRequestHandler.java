package com.wb3tech.bce.domain.customer.create;

import com.wb3tech.bce.domain.customer.CustomerGateway;
import com.wb3tech.kernel.RequestHandler;

public class CreateCustomerRequestHandler implements RequestHandler<CreateCustomerRequest> {

    private final CustomerGateway gateway;

    public CreateCustomerRequestHandler(CustomerGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void Handle(CreateCustomerRequest createCustomerRequest) {
        var newCustomer = new CreateCustomerUseCase(createCustomerRequest);
        newCustomer.execute();
        this.gateway.Create(newCustomer.getCustomer());
    }

}
