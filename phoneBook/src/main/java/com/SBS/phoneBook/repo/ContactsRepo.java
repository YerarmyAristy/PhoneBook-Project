package com.SBS.phoneBook.repo;

import com.SBS.phoneBook.model.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ContactsRepo extends JpaRepository<Contacts, Long> {
    void deleteContactsById(Long id);

    Optional<Contacts> findContactsById(Long id);
}
