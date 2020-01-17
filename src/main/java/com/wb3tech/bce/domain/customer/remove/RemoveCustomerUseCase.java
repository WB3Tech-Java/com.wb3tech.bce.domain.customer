package com.wb3tech.bce.domain.customer.remove;

import com.wb3tech.bce.domain.customer.Customer;
import com.wb3tech.bce.domain.customer.CustomerGateway;
import com.wb3tech.kernel.UseCase;

public class RemoveCustomerUseCase implements UseCase {

    private final RemoveCustomerRequest request;
    private Customer customer;

    public RemoveCustomerUseCase(RemoveCustomerRequest removeCustomerRequest) {
        this.request = removeCustomerRequest;
    }

    @Override
    public void execute() {
        this.customer = Customer.Of(request);
    }

    public Customer getCustomer() {
        return this.customer;
    }
}
