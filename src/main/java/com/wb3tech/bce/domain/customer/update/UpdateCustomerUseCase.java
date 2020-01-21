package com.wb3tech.bce.domain.customer.update;

import com.wb3tech.bce.domain.customer.Customer;
import com.wb3tech.bce.domain.customer.CustomerGateway;
import com.wb3tech.kernel.conroller.CommandUseCase;

public class UpdateCustomerUseCase implements CommandUseCase<UpdateCustomerRequest> {

    private final CustomerGateway gateway;

    public UpdateCustomerUseCase(CustomerGateway gateway) {
        this.gateway = gateway;
    }

    public void execute(UpdateCustomerRequest request) {
        var customer = Customer.Of(request);
        this.gateway.Update(customer);
    }
}
