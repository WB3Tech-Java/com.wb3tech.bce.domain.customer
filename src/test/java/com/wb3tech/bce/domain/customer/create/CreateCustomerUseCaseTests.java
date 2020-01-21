package com.wb3tech.bce.domain.customer.create;

import com.wb3tech.bce.domain.customer.CustomerGatewaySpy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Customer Domain - Use Case - Create Customer")
public class CreateCustomerUseCaseTests {

    private CustomerGatewaySpy gateway;

    @BeforeEach
    void setup() {
        this.gateway = new CustomerGatewaySpy();
    }

    @Test @Tag("Medium") @DisplayName("Create Customer successfully with event being dispatched.")
    void CreateCustomer() {

        var eventHandler = new CustomerCreatedEventHandlerSpy();
        var request = new CreateCustomerRequest("Bill", "Bensing");
        var usecase = new CreateCustomerUseCase(this.gateway, eventHandler);

        usecase.execute(request);

        assertNotNull(request.getId());
        assertEquals("Bill", request.getFirstName());
        assertEquals("Bensing", request.getLastName());
        assertTrue(this.gateway.CreateWasCalled());
        assertTrue(eventHandler.CustomerCreatedEventWasHandled());

        var handledEvent = eventHandler.getDispatchedEvent();

        assertEquals(request.getId(), handledEvent.getId());
        assertEquals(request.getFirstName(), handledEvent.getFirstName());
        assertEquals(request.getLastName(), handledEvent.getLastName());

    }

    private class CustomerCreatedEventHandlerSpy implements CustomerCreatedEventDispatcher {

        private boolean wasCreated;
        private CustomerCreatedEvent event;

        public boolean CustomerCreatedEventWasHandled() {
            return this.wasCreated;
        }

        public CustomerCreatedEvent getDispatchedEvent() {
            return this.event;
        }

        @Override
        public void Dispatch(CustomerCreatedEvent customerCreatedEvent) {
            this.event = customerCreatedEvent;
            this.wasCreated = true;
        }


    }

}
