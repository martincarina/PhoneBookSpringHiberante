package ru.academits.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value = "getAllContacts", method = RequestMethod.GET)
    @ResponseBody
    public List<Contact> getAllContacts() {
        logger.info("called method getAllContacts");
        return contactService.getAllContacts();
    }

    @RequestMapping(value = "addContact", method = RequestMethod.POST)
    @ResponseBody
    public ContactValidation addContact(@RequestBody Contact contact) {
        return contactService.addContact(contact);
    }

    @RequestMapping(value = "removeContacts", method = RequestMethod.POST)
    @ResponseBody
    public void removeContacts(@RequestParam("ids[]") String[] ids) {
        contactService.removeContacts(ids);
    }
}


