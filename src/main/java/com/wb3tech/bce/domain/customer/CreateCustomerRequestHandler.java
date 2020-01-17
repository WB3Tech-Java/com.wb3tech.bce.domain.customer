package com.wb3tech.bce.domain.customer;

import com.wb3tech.kernel.RequestHandler;

public class CreateCustomerRequestHandler implements RequestHandler<CreateCustomerRequest> {

    private final CustomerGateway gateway;

    public CreateCustomerRequestHandler(CustomerGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void Handle(CreateCustomerRequest createCustomerRequest) {
        new CreateCustomer(createCustomerRequest, this.gateway).execute();
    }

}
