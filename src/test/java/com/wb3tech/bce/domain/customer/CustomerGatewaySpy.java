package com.wb3tech.bce.domain.customer;

import com.wb3tech.kernel.entity.Identifiable;
import com.wb3tech.kernel.entity.Identity;

import javax.swing.text.html.Option;
import java.util.Optional;

public class CustomerGatewaySpy implements CustomerGateway {

    private boolean createWasCalled;
    private boolean updateWasCalled;
    private boolean removeWasCalled;
    private boolean findWasCalled;

    private Customer foundCusotmer;

    public boolean CreateWasCalled() {
        return this.createWasCalled;
    }

    public boolean UpdateWasCalled() {
        return this.updateWasCalled;
    }

    public boolean RemoveWasCalled() {
        return this.removeWasCalled;
    }

    public boolean FindWasCalled() {
        return this.findWasCalled;
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

    public Optional<CustomerEntity> Find(Identity identity) {
        this.findWasCalled = true;
        return Optional.ofNullable(this.foundCusotmer);
    }

    public void setFoundCustomerAs(Customer customer) {
        this.foundCusotmer = customer;
    }
}