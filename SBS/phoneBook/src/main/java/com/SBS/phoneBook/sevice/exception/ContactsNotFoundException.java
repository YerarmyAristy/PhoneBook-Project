package com.SBS.phoneBook.sevice.exception;

public class  ContactsNotFoundException extends RuntimeException {
    public ContactsNotFoundException(String message) {
        super(message);
    }
}
