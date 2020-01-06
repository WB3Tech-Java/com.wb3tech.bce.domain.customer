package com.wb3tech.bce.domain.customer;

import com.wb3tech.kernel.RequestHandler;

public class RemoveCustomerUseCaseRequestHandler implements RequestHandler<RemoveCustomerRequest> {

    private final CustomerGateway gateway;

    public RemoveCustomerUseCaseRequestHandler(CustomerGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void Handle(RemoveCustomerRequest removeCustomerRequest) {
        new RemoveCustomer(removeCustomerRequest, this.gateway).execute();
    }
}
