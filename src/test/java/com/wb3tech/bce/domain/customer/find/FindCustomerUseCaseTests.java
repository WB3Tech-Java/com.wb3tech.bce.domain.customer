package com.wb3tech.bce.domain.customer.find;

import com.wb3tech.bce.domain.customer.Customer;
import com.wb3tech.bce.domain.customer.CustomerGatewaySpy;
import com.wb3tech.kernel.entity.Identity;
import org.junit.jupiter.api.*;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Customer Domain - Use Case - Find Customer")
public class FindCustomerUseCaseTests {

    private CustomerGatewaySpy gateway;

    @BeforeEach
    void setup() {
        this.gateway = new CustomerGatewaySpy();
    }

    @Test @Tag("Medium") @DisplayName("Find Customer successfully.")
    public void FindCustomer() {

        var id = UUID.fromString("bbe2ee9e-dda1-4d24-92c2-91e35ea55a49");
        var customerToFind = Customer.of(Identity.New(id), "Bill", "Bensing");
        this.gateway.setFoundCustomerAs(customerToFind);

        var request = new FindCustomerRequest(id);
        var usecase = new FindCustomerUseCase(this.gateway);

        var response = usecase.execute(request);

        assertTrue(this.gateway.FindWasCalled());
        assertTrue(response.doesExist());
        assertEquals(response.getId(), id);
        assertEquals(response.getFirstName(), "Bill");
        assertEquals(response.getLastName(), "Bensing");

    }

    @Test @Tag("Medium") @DisplayName("Customer cannot be found, should return an instance of a default object with a 'does not exist' flag set as 'true'")
    public void CustomerDoesNotExit() {

        var request = new FindCustomerRequest(UUID.randomUUID());
        var usecase = new FindCustomerUseCase(this.gateway);

        var response = usecase.execute(request);

        assertTrue(this.gateway.FindWasCalled());
        Assertions.assertFalse(response.doesExist());
        assertEquals(response.getId().toString(), "00000000-0000-0000-0000-000000000000");
        assertEquals(response.getFirstName(), "");
        assertEquals(response.getLastName().toString(), "");

    }

}
