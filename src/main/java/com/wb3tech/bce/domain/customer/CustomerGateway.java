package com.wb3tech.bce.domain.customer;

import com.wb3tech.kernel.entity.Identifiable;
import com.wb3tech.kernel.entity.Identity;

import java.util.Optional;

public interface CustomerGateway {

    void Create(CustomerEntity customer);

    void Update(CustomerEntity customer);

    void Remove(Identifiable identity);

    Optional<CustomerEntity> Find(Identity identity);

}
