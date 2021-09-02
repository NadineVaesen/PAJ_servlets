package be.pxl.paj.servlets.dao;

import be.pxl.paj.servlets.domain.PhonebookEntry;
import be.pxl.paj.servlets.service.resources.PhonebookSearchResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PhonebookDAO extends JpaRepository<PhonebookEntry, Long> {


    PhonebookEntry findPhonebookEntryByFirstNameAndLastName(String firstName, String lastName);
}
