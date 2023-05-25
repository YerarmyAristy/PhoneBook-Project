package com.SBS.phoneBook.controller;
import com.SBS.phoneBook.model.Contacts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import static org.junit.jupiter.api.Assertions.*;

class ContactsValidatorTest {
    private ContactsValidator contactsValidator;
    private Contacts validContacts;
    private Errors errors;

    @BeforeEach
    public void setup() {
        contactsValidator = new ContactsValidator();
        validContacts = new Contacts();
        validContacts.setFirstName("Joe");
        validContacts.setPhoneNumber("123.456.7890");
        validContacts.setEmail("john@example.com");
        errors = new BeanPropertyBindingResult(validContacts, "validContacts");
    }

    @Test
    public void testValidate_WithValidContacts_NoErrors() {
        contactsValidator.validate(validContacts, errors);
        assertFalse(errors.hasErrors(), "No errors should be present");
    }

    @Test
    public void testValidate_WithEmptyFirstName_Error() {
        validContacts.setFirstName("");
        contactsValidator.validate(validContacts, errors);
        assertTrue(errors.hasErrors(), "Errors should be present");
        assertTrue(errors.hasFieldErrors("firstName"), "Error should be present for 'firstName' field");
    }

    @Test
    public void testValidate_WithInvalidPhoneNumber_Error() {
        validContacts.setPhoneNumber("1234567890");
        contactsValidator.validate(validContacts, errors);
        assertTrue(errors.hasErrors(), "Errors should be present");
        assertTrue(errors.hasFieldErrors("phoneNumber"), "Error should be present for 'phoneNumber' field");
    }

    @Test
    public void testValidate_WithInvalidEmail_Error() {
        validContacts.setEmail("john@example");
        contactsValidator.validate(validContacts, errors);
        assertTrue(errors.hasErrors(), "Errors should be present");
        assertTrue(errors.hasFieldErrors("email"), "Error should be present for 'email' field");
    }
}