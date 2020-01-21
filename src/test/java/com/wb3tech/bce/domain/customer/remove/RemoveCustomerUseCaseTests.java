package com.wb3tech.bce.domain.customer.remove;

import com.wb3tech.bce.domain.customer.CustomerGatewaySpy;
import org.junit.jupiter.api.*;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Customer Domain - Use Case - Remove Customer")
class RemoveCustomerUseCaseTests {

    private CustomerGatewaySpy gateway;

    @BeforeEach
    void setup() {
        this.gateway = new CustomerGatewaySpy();
    }

    @Test @Tag("Medium") @DisplayName("Remove Customer successfully with event being dispatched.")
    void RemoveCustomer() {

        var id = UUID.fromString("bbe2ee9e-dda1-4d24-92c2-91e35ea55a49");
        var request = new RemoveCustomerRequest(id);
        var dispatcher = new CustomerRemovedEventDispatcherSpy();
        var usecase = new RemoveCustomerUseCase(this.gateway, dispatcher);

        usecase.execute(request);

        assertTrue(this.gateway.RemoveWasCalled());

        var removedCustomer = dispatcher.getEvent();

        assertTrue(dispatcher.wasCalled());
        assertEquals(request.getId(), removedCustomer.getId());


    }


    private class CustomerRemovedEventDispatcherSpy implements CustomerRemovedEventDispatcher {

        private boolean isCalled;
        private CustomerRemovedEvent event;

        public boolean wasCalled() {
            return isCalled;
        }

        public CustomerRemovedEvent getEvent() {
            return event;
        }

        @Override
        public void Dispatch(CustomerRemovedEvent customerRemovedEvent) {
            this.isCalled = true;
            this.event = customerRemovedEvent;
        }

    }

}