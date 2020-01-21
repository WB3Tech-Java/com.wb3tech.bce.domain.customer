package com.wb3tech.bce.domain.customer;

import com.wb3tech.bce.domain.customer.create.CreateCustomerRequest;
import com.wb3tech.bce.domain.customer.create.CreateCustomerUseCase;
import com.wb3tech.bce.domain.customer.remove.RemoveCustomerRequest;
import com.wb3tech.bce.domain.customer.remove.RemoveCustomerUseCase;
import com.wb3tech.bce.domain.customer.update.UpdateCustomerRequest;
import com.wb3tech.bce.domain.customer.update.UpdateCustomerUseCase;
import org.junit.jupiter.api.*;

import java.util.UUID;

@DisplayName("Customer Use Cases")
class CustomerUseCaseTests {

    private CustomerGatewaySpy gateway;

    @BeforeEach
    void setup() {
        this.gateway = new CustomerGatewaySpy();
    }

    @Test @Tag("Medium") @DisplayName("Create Customer")
    // Given the need to create a new customer
    // When I supply the first name as "Bill"
    //  and the last name as "Bensing"
    // Then a customer should be created with a valid UUID
    //  and the first name shall be "Bill"
    //  and the last name shall be "Bensing"
    //  and the CustomerGateway.Create(...) must be invoked
    void CreateCustomer() {

        var request = new CreateCustomerRequest("Bill", "Bensing");
        var usecase = new CreateCustomerUseCase(this.gateway);

        usecase.execute(request);

        Assertions.assertNotNull(request.getId());
        Assertions.assertEquals("Bill", request.getFirstName());
        Assertions.assertEquals("Bensing", request.getLastName());
        Assertions.assertTrue(this.gateway.CreateWasCalled());
    }

    @Test @Tag("Medium") @DisplayName("Update Customer")
    // Given the need to update an existing customer
    // When the customer id is "bbe2ee9e-dda1-4d24-92c2-91e35ea55a49"
    //  and the first name is changed to "Billy"
    //  and the last name is changed to "Bensing III"
    // Then the customer should be updated with a first name of "Billy"
    //  and the a last name of "Bensing III"
    //  and the CustomerGateway.Update(...) must be invoked
    void UpdateCustomer() {

        var request = new UpdateCustomerRequest(UUID.fromString("bbe2ee9e-dda1-4d24-92c2-91e35ea55a49"), "Billy", "Bensing III");
        var usecase = new UpdateCustomerUseCase(this.gateway);

        usecase.execute(request);

        Assertions.assertEquals("bbe2ee9e-dda1-4d24-92c2-91e35ea55a49", request.getId().toString());
        Assertions.assertEquals("Billy", request.getFirstName());
        Assertions.assertEquals("Bensing III", request.getLastName());
        Assertions.assertTrue(this.gateway.UpdateWasCalled());

    }

    @Test @Tag("Medium") @DisplayName("Remove Customer")
    // Given the need to update an existing customer
    // When the customer id is "bbe2ee9e-dda1-4d24-92c2-91e35ea55a49"
    //  and the first name is changed to "Billy"
    //  and the last name is changed to "Bensing III"
    // Then the customer should be updated with a first name of "Billy"
    //  and the a last name of "Bensing III"
    //  and the CustomerGateway.Update(...) must be invoked
    void RemoveCustomer() {

        var id = UUID.fromString("bbe2ee9e-dda1-4d24-92c2-91e35ea55a49");
        var request = new RemoveCustomerRequest(id);
        var usecase = new RemoveCustomerUseCase(this.gateway);

        usecase.execute(request);

        Assertions.assertTrue(this.gateway.RemoveWasCalled());

    }
}