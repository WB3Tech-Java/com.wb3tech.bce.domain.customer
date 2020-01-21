package com.wb3tech.bce.domain.customer;

import com.wb3tech.kernel.entity.Identifiable;

public class CustomerGatewaySpy implements CustomerGateway {

    private boolean createWasCalled;
    private boolean updateWasCalled;
    private boolean removeWasCalled;

    public boolean CreateWasCalled() {
        return this.createWasCalled;
    }

    public boolean UpdateWasCalled() {
        return this.updateWasCalled;
    }

    public boolean RemoveWasCalled() {
        return this.removeWasCalled;
    }

    public void Create(CustomerEntity customer) {
        this.createWasCalled = true;
    }

    public void Update(CustomerEntity customer) {
        this.updateWasCalled = true;
    }

    public void Remove(Identifiable identifiable) {
        this.removeWasCalled = true;
    }
}