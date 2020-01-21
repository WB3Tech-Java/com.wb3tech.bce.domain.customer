package com.wb3tech.bce.domain.customer;

import com.wb3tech.kernel.entity.Identity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Customer Entity")
public class CustomerEntityTests {

    @Test @DisplayName("First Name - Default to empty string when null is provided")
    public void EmptyStringFirstName() {

        var customer = Customer.Of(null, "Bensing");
        Assertions.assertEquals(customer.getFirstName(), "");

    }

    @Test @DisplayName("First Name - Default to empty string when string with spaces is provided")
    public void FirstNameOnlySpaces() {

        var customer = Customer.Of("     ", "Bensing");
        Assertions.assertEquals(customer.getFirstName(), "");

    }

    @Test @DisplayName("First Name - Trim Whitespace around first name")
    public void FirstNameWithLeadingAndTrailingWhitespace() {

        var customer = Customer.Of(" Bill ", "Bensing");
        Assertions.assertEquals(customer.getFirstName(), "Bill");

    }

    @Test @DisplayName("Last Name - Default to empty string when null is provided")
    public void EmptyStringLastName() {

        var customer = Customer.Of("Bill", null);
        Assertions.assertEquals(customer.getLastName(), "");

    }

    @Test @DisplayName("Last Name - Default to empty string when string with spaces is provided")
    public void LastNameOnlySpaces() {

        var customer = Customer.Of("Bill", "   ");
        Assertions.assertEquals(customer.getLastName(), "");

    }

    @Test @DisplayName("Last Name - Trim Whitespace around last name")
    public void LastNameWithLeadingAndTrailingWhitespace() {

        var customer = Customer.Of(" Bill ", "   Bensing   ");
        Assertions.assertEquals(customer.getLastName(), "Bensing");

    }

    @Test @DisplayName("Customer Entity Equality - Identity does not match")
    public void CustomerEqualityIdentityMisMatch() {

        var customer1 = Customer.Of("Bill", "Bensing");
        var customer2 = Customer.Of("Bill", "Bensing");

        Assertions.assertNotEquals(customer1.getId(), customer2.getId());

    }

    @Test @DisplayName("Customer Entity Equality - First Name does not match")
    public void CustomerEqualityFirstNameMisMatch() {

        var customer1 = Customer.Of("Bill", "Bensing");
        var customer2 = Customer.Of("William", "Bensing");

        Assertions.assertNotEquals(customer1.getFirstName(), customer2.getFirstName());

    }

    @Test @DisplayName("Customer Entity Equality - Last Name does not match")
    public void CustomerEqualityLastNameMisMatch() {

        var customer1 = Customer.Of("Bill", "Bensing");
        var customer2 = Customer.Of("Bill", "Bensinger");

        Assertions.assertNotEquals(customer1.getLastName(), customer2.getLastName());

    }

    @Test @DisplayName("Customer Entity Equality - Both Entities are equal")
    public void CustomerEntitiesEqual() {

        var identity = Identity.New();
        var customer1 = Customer.Of(identity, "Bill", "Bensing");
        var customer2 = Customer.Of(identity, "Bill", "Bensing");

        Assertions.assertTrue(customer1.equals(customer2));
    }

}
