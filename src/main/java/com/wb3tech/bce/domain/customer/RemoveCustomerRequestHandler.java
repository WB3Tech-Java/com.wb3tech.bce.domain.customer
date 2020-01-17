package com.wb3tech.bce.domain.customer;

import com.wb3tech.kernel.RequestHandler;

public class RemoveCustomerRequestHandler implements RequestHandler<RemoveCustomerRequest> {

    private final CustomerGateway gateway;

    public RemoveCustomerRequestHandler(CustomerGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void Handle(RemoveCustomerRequest removeCustomerRequest) {
        new RemoveCustomerUseCase(removeCustomerRequest, this.gateway).execute();
    }
}
