package com.wb3tech.bce.domain.customer.remove;
import com.wb3tech.bce.domain.customer.CustomerRequest;

import java.util.UUID;

public class RemoveCustomerRequest extends CustomerRequest {

    public RemoveCustomerRequest(UUID uuid) {
        super();
        this.setId(uuid);
    }

}
