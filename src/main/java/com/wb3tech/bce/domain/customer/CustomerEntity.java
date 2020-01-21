package com.wb3tech.bce.domain.customer;

import com.wb3tech.kernel.entity.Identifiable;

public interface CustomerEntity extends Identifiable {

    String getFirstName();
    String getLastName();

    boolean equals(CustomerEntity entity);

}
