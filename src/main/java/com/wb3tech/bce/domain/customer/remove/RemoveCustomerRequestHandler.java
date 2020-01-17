package com.wb3tech.bce.domain.customer.remove;

import com.wb3tech.bce.domain.customer.CustomerGateway;
import com.wb3tech.kernel.RequestHandler;

public class RemoveCustomerRequestHandler implements RequestHandler<RemoveCustomerRequest> {

    private final CustomerGateway gateway;

    public RemoveCustomerRequestHandler(CustomerGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void Handle(RemoveCustomerRequest removeCustomerRequest) {
        var usecase = new RemoveCustomerUseCase(removeCustomerRequest);
        usecase.execute();
        this.gateway.Remove(usecase.getCustomer());
    }
}
