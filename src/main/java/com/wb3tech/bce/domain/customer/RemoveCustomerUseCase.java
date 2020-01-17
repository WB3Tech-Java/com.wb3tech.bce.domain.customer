package com.wb3tech.bce.domain.customer;

import com.wb3tech.kernel.UseCase;

public class RemoveCustomerUseCase implements UseCase {

    private final RemoveCustomerRequest request;
    private final CustomerGateway gateway;

    public RemoveCustomerUseCase(RemoveCustomerRequest removeCustomerRequest, CustomerGateway gateway) {
        this.request = removeCustomerRequest;
        this.gateway = gateway;
    }

    @Override
    public void execute() {
        var customer = new Customer(request);
        this.gateway.Remove(customer);
    }
}
