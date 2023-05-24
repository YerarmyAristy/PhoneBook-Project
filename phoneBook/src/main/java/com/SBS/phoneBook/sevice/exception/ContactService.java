package com.SBS.phoneBook.sevice.exception;

import com.SBS.phoneBook.model.Contacts;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    List<Contacts> findAllContacts();
    Optional<Contacts> findById(Long id);
    Contacts saveContacts(Contacts contacts);
    Contacts updateContacts(Contacts contacts);
    void deleteContacts(Long id);
}
