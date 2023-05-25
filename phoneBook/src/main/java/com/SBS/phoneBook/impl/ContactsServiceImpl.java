package com.SBS.phoneBook.impl;

import com.SBS.phoneBook.model.Contacts;
import com.SBS.phoneBook.repo.ContactsRepo;
import com.SBS.phoneBook.sevice.exception.ContactService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactsServiceImpl implements ContactService {
    private final ContactsRepo contactsRepo;

    public ContactsServiceImpl(ContactsRepo contactsRepo) {
        this.contactsRepo = contactsRepo;
    }

    @Override
    public List<Contacts> findAllContacts() {
        return contactsRepo.findAll();
    }

    @Override
    public Optional<Contacts> findById(Long id) {
        return contactsRepo.findById(id);
    }

    @Override
    public Contacts saveContacts(Contacts contacts) {
        return contactsRepo.save(contacts);
    }

    @Override
    public Contacts updateContacts(Contacts contacts) {
        return contactsRepo.save(contacts);
    }

    @Override
    public void deleteContacts(Long id) {
    contactsRepo.deleteById(id);
    }
}
