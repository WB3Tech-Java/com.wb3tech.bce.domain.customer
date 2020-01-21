package com.wb3tech.bce.domain.customer.update;

import com.wb3tech.bce.domain.customer.CustomerGatewaySpy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Customer Domain - Use Case - Update Customer")
public class UpdateCustomerUseCaseTests {

    private CustomerGatewaySpy gateway;

    @BeforeEach
    void setup() {
        this.gateway = new CustomerGatewaySpy();
    }

    @Test @Tag("Medium") @DisplayName("Update Customer successfully with event being dispatched.")
    void UpdateCustomer() {

        var request = new UpdateCustomerRequest(UUID.fromString("bbe2ee9e-dda1-4d24-92c2-91e35ea55a49"), "Billy", "Bensing III");
        var eventDispatcher = new CustomerUpdatedEventDispatcherSpy();
        var usecase = new UpdateCustomerUseCase(this.gateway, eventDispatcher);

        usecase.execute(request);

        assertEquals("bbe2ee9e-dda1-4d24-92c2-91e35ea55a49", request.getId().toString());
        assertEquals("Billy", request.getFirstName());
        assertEquals("Bensing III", request.getLastName());

        assertTrue(this.gateway.UpdateWasCalled());

        var removedCustomer= eventDispatcher.getEvent();

        assertTrue(eventDispatcher.wasCalled());
        assertEquals(request.getId(), removedCustomer.getId());
        assertEquals(request.getFirstName(), removedCustomer.getFirstName());
        assertEquals(request.getLastName(), removedCustomer.getLastName());

    }

    class CustomerUpdatedEventDispatcherSpy implements CustomerUpdatedEventDispatcher {

        private boolean isCalled;
        private CustomerUpdatedEvent event;

        @Override
        public void Dispatch(CustomerUpdatedEvent customerUpdatedEvent) {
            this.isCalled = true;
            this.event = customerUpdatedEvent;
        }

        public boolean wasCalled() {
            return isCalled;
        }

        public CustomerUpdatedEvent getEvent() {
            return event;
        }

    }

}
