package com.wb3tech.bce.domain.customer.update;

import com.wb3tech.bce.domain.customer.CustomerGateway;
import com.wb3tech.kernel.RequestHandler;

public class UpdateCustomerRequestHandler implements RequestHandler<UpdateCustomerRequest> {

    private final CustomerGateway gateway;

    public UpdateCustomerRequestHandler(CustomerGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void Handle(UpdateCustomerRequest updateCustomerRequest) {
        new UpdateCustomerUseCase(updateCustomerRequest, this.gateway).execute();
    }


}
