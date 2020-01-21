package com.wb3tech.bce.domain.customer.update;

import com.wb3tech.bce.domain.customer.Customer;
import com.wb3tech.bce.domain.customer.CustomerGateway;
import com.wb3tech.kernel.conroller.CommandUseCase;
import com.wb3tech.kernel.entity.Identity;

public class UpdateCustomerUseCase implements CommandUseCase<UpdateCustomerRequest> {

    private final CustomerGateway gateway;
    private final CustomerUpdatedEventDispatcher eventDispatcher;

    public UpdateCustomerUseCase(CustomerGateway gateway, CustomerUpdatedEventDispatcher eventDispatcher) {
        this.gateway = gateway;
        this.eventDispatcher = eventDispatcher;
    }

    public void execute(UpdateCustomerRequest request) {
        var customer = Customer.Of(Identity.New(request.getId()), request.getFirstName(), request.getLastName());
        this.gateway.Update(customer);
        this.eventDispatcher.Dispatch(CustomerUpdatedEvent.Of(customer));
    }

}
