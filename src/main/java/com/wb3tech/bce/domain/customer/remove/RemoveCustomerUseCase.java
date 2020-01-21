package com.wb3tech.bce.domain.customer.remove;

import com.wb3tech.bce.domain.customer.Customer;
import com.wb3tech.bce.domain.customer.CustomerGateway;
import com.wb3tech.kernel.conroller.CommandUseCase;

public class RemoveCustomerUseCase implements CommandUseCase<RemoveCustomerRequest> {

    private CustomerGateway gateway;

    public RemoveCustomerUseCase(CustomerGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void execute(RemoveCustomerRequest request) {
        var customer = Customer.Of(request);
        this.gateway.Remove(customer);
    }

}
