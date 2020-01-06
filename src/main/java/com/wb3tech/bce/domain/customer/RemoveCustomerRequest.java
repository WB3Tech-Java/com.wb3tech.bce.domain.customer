package com.wb3tech.bce.domain.customer;
import java.util.UUID;

public class RemoveCustomerRequest extends CustomerRequest {

    public RemoveCustomerRequest(UUID uuid) {
        super();
        this.setId(uuid);
    }

}
