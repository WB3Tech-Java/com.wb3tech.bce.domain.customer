package com.wb3tech.bce.domain.customer.remove;

import com.wb3tech.bce.domain.customer.Customer;
import com.wb3tech.bce.domain.customer.CustomerGateway;
import com.wb3tech.kernel.conroller.CommandUseCase;

public class RemoveCustomerUseCase implements CommandUseCase<RemoveCustomerRequest> {

    private CustomerRemovedEventDispatcher eventDispatcher;
    private CustomerGateway gateway;

    public RemoveCustomerUseCase(CustomerGateway gateway, CustomerRemovedEventDispatcher eventDispatcher) {
        this.gateway = gateway;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public void execute(RemoveCustomerRequest request) {
        var customer = Customer.Of(request.getId());
        this.gateway.Remove(customer);
        this.eventDispatcher.Dispatch(CustomerRemovedEvent.Of(customer));
    }

}
