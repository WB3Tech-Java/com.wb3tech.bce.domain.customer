package com.wb3tech.bce.domain.customer.find;

import com.wb3tech.bce.domain.customer.CustomerGateway;
import com.wb3tech.kernel.conroller.QueryUseCase;
import com.wb3tech.kernel.entity.Identity;

public class FindCustomerUseCase implements QueryUseCase<FindCustomerRequest, FindCustomerResponse> {

    private final CustomerGateway gateway;

    public FindCustomerUseCase(CustomerGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public FindCustomerResponse execute(FindCustomerRequest findCustomerRequest) {
        var identity = Identity.New(findCustomerRequest.getId());
        var customer = this.gateway.Find(identity);
        return customer.map(FindCustomerResponse::of).orElseGet(FindCustomerResponse::DoesNotExist);
    }

}
