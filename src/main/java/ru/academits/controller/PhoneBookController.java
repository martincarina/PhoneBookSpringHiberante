package ru.academits.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.academits.converter.ContactDtoToContactConverter;
import ru.academits.converter.ContactToContactDtoConverter;
import ru.academits.dto.ContactDto;
import ru.academits.model.Contact;
import ru.academits.model.ContactValidation;
import ru.academits.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Controller
@RequestMapping("/phoneBook/rcp/api/v1")
public class PhoneBookController {

    private static final Logger logger = LoggerFactory.getLogger(PhoneBookController.class);

    @Autowired
    private ContactService contactService;

    @Autowired
    private ContactToContactDtoConverter contactToContactDtoConverter;

    @Autowired
    private ContactDtoToContactConverter contactDtoToContactConverter;

    @RequestMapping(value = "getAllContacts", method = RequestMethod.GET)
    @ResponseBody
    public List<ContactDto> getAllContacts() {
        logger.info("called method getAllContacts");
        return contactToContactDtoConverter.convert(contactService.getAllContacts());
    }

    @RequestMapping(value = "addContact", method = RequestMethod.POST)
    @ResponseBody
    public ContactValidation addContact(@RequestBody ContactDto contact) {
        Contact contactEntity = contactDtoToContactConverter.convert(contact);
        return contactService.addContact(contactEntity);
    }

    @RequestMapping(value = "removeContacts", method = RequestMethod.POST)
    @ResponseBody
    public void removeContacts(@RequestParam("ids[]") String[] ids) {
        contactService.removeContacts(ids);
    }
}


