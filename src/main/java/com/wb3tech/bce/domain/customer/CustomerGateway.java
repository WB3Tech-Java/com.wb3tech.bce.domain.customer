package com.wb3tech.bce.domain.customer;

public interface CustomerGateway {

    void Create(CustomerEntity customer);

    void Update(CustomerEntity customer);

    void Remove(CustomerEntity customer);
}
