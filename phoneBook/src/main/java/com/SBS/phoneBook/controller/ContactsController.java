package com.SBS.phoneBook.controller;

import com.SBS.phoneBook.model.Contacts;
import com.SBS.phoneBook.sevice.exception.ContactService;
import com.SBS.phoneBook.sevice.exception.ContactsNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/contacts")
public class ContactsController {
    private final ContactService contactService;
    private final ContactsValidator contactsValidator;


    public ContactsController(ContactService contactService, ContactsValidator contactsValidator) {
        this.contactService = contactService;
        this.contactsValidator = contactsValidator;
    }
@GetMapping
    public List<Contacts> findAllContacts() {
        return contactService.findAllContacts();
    }
@GetMapping("/{id}")
    public Optional<Contacts> findContactsById(@PathVariable("id") Long id){
        return Optional.ofNullable(contactService.findById(id).orElseThrow(() -> new ContactsNotFoundException("User by id " + id + "was not found")));
    }
    @PostMapping("/add")
    public Contacts saveContacts(@RequestBody  Contacts contacts, BindingResult bindingResult) {
        contactsValidator.validate(contacts, bindingResult);
        if (bindingResult.hasErrors()) {

        }
        return contactService.saveContacts(contacts);
    }
    @PutMapping("/update")
    public Contacts updateContacts(@RequestBody  Contacts contacts) {
        return contactService.updateContacts(contacts);
    }
    @DeleteMapping("/delete/{id}")
    public  void deleteContacts(@PathVariable("id") Long id){
        contactService.deleteContacts(id);
    }
}
