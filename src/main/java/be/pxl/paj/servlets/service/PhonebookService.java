package be.pxl.paj.servlets.service;

import be.pxl.paj.servlets.dao.PhonebookDAO;
import be.pxl.paj.servlets.domain.PhonebookEntry;
import be.pxl.paj.servlets.service.dto.PhonebookDTO;
import be.pxl.paj.servlets.service.resources.PhonebookResource;
import be.pxl.paj.servlets.service.resources.PhonebookSearchResource;
import org.springframework.stereotype.Service;

@Service
public class PhonebookService {

    private final PhonebookDAO phonebookDAO;

    public PhonebookService(PhonebookDAO phonebookDAO) {
        this.phonebookDAO = phonebookDAO;

    }

    public void createNewPhonebookEntry(PhonebookResource phonebookResource) {
        PhonebookEntry phonebookEntry = mapToPhoneBookEntry(phonebookResource);
        phonebookDAO.save(phonebookEntry);
    }

    private PhonebookEntry mapToPhoneBookEntry(PhonebookResource phonebookResource) {
        PhonebookEntry phonebookEntry = new PhonebookEntry();

        phonebookEntry.setFirstName(phonebookResource.getFirstName());
        phonebookEntry.setLastName(phonebookResource.getLastName());
        phonebookEntry.setPhoneNumber(phonebookResource.getPhoneNumber());

        return phonebookEntry;
    }

    public PhonebookDTO findPhonenumberByName(PhonebookSearchResource phonebookSearchResource) {
        return mapToPhoneBookDTO(phonebookDAO.findPhonebookEntryByFirstNameAndLastName(phonebookSearchResource.getFirstName(), phonebookSearchResource.getLastName()));
    }

    private PhonebookDTO mapToPhoneBookDTO(PhonebookEntry phonebookEntry){
        PhonebookDTO phonebookDTO = new PhonebookDTO();
        phonebookDTO.setFirstName(phonebookEntry.getFirstName());
        phonebookDTO.setLastName(phonebookEntry.getLastName());
        phonebookDTO.setPhoneNumber(phonebookEntry.getPhoneNumber());
        return phonebookDTO;
    }
}
