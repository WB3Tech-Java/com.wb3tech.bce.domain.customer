package com.wb3tech.bce.domain.customer;

import com.wb3tech.kernel.RequestHandler;

public class UpdateCustomerRequestHandler implements RequestHandler<UpdateCustomerRequest> {

    private final CustomerGateway gateway;

    public UpdateCustomerRequestHandler(CustomerGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void Handle(UpdateCustomerRequest updateCustomerRequest) {
        new UpdateCustomer(updateCustomerRequest, this.gateway).execute();
    }


}
