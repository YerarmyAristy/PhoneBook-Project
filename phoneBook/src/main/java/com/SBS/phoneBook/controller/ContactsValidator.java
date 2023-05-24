package com.SBS.phoneBook.controller;

import com.SBS.phoneBook.model.Contacts;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ContactsValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Contacts.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "field.required");

        Contacts contacts = (Contacts) target;

        // Phone number validation
        if (!contacts.getPhoneNumber().matches("\\d{3}\\.\\d{3}\\.\\d{4}")) {
            errors.rejectValue("phoneNumber", "phone.invalid", "Phone Number must be in the format: XXX.XXX.XXXX");
        }

        // Email validation
        if (contacts.getEmail() != null && !contacts.getEmail().isEmpty()) ;{
            if (!isValidEmail(contacts.getEmail())) {
                errors.rejectValue("email", "email.invalid", "Email Address must be in a valid email format");
            }
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[\\w-_.+]*[\\w-_.]@(\\w+\\.)+\\w+\\w$";
        return email.matches(emailRegex);
    }
        }



