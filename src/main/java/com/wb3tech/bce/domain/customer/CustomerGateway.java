package com.wb3tech.bce.domain.customer;

import com.wb3tech.kernel.entity.Identifiable;

public interface CustomerGateway {

    void Create(CustomerEntity customer);

    void Update(CustomerEntity customer);

    void Remove(Identifiable identity);

}
