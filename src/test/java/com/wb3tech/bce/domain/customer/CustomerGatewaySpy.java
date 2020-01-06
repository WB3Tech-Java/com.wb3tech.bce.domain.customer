package com.wb3tech.bce.domain.customer;

class CustomerGatewaySpy implements CustomerGateway {

    private boolean createWasCalled;
    private boolean updateWasCalled;
    private boolean removeWasCalled;

    boolean CreateWasCalled() {
        return this.createWasCalled;
    }
    boolean UpdateWasCalled() {
        return this.updateWasCalled;
    }
    boolean RemoveWasCalled() {
        return this.removeWasCalled;
    }

    public void Create(CustomerEntity customer) {
        this.createWasCalled = true;
    }

    public void Update(CustomerEntity customer) {
        this.updateWasCalled = true;
    }

    public void Remove(CustomerEntity customer) {
        this.removeWasCalled = true;
    }
}