package ru.academits.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.academits.dao.ContactDao;
import ru.academits.model.Contact;
import ru.academits.model.ContactValidation;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactDao contactDao;

    private boolean isExistContactWithPhone(String phone) {
        List<Contact> contactList = contactDao.findByPhone(phone);
        return !contactList.isEmpty();
    }

    public ContactValidation validateContact(Contact contact) {
        ContactValidation contactValidation = new ContactValidation();
        contactValidation.setValid(true);
        if (contact.getFirstName().isEmpty()) {
            contactValidation.setValid(false);
            contactValidation.setError("Поле Имя должно быть заполнено.");
            return contactValidation;
        }

        if (contact.getLastName().isEmpty()) {
            contactValidation.setValid(false);
            contactValidation.setError("Поле Фамилия должно быть заполнено.");
            return contactValidation;
        }

        if (contact.getPhone().isEmpty()) {
            contactValidation.setValid(false);
            contactValidation.setError("Поле Телефон должно быть заполнено.");
            return contactValidation;
        }

        if (isExistContactWithPhone(contact.getPhone())) {
            contactValidation.setValid(false);
            contactValidation.setError("Номер телефона не должен дублировать другие номера в телефонной книге.");
            return contactValidation;
        }
        return contactValidation;
    }

    public ContactValidation addContact(Contact contact) {
        ContactValidation contactValidation = validateContact(contact);
        if (contactValidation.isValid()) {
            contactDao.add(contact);
        }
        return contactValidation;
    }

    public List<Contact> getAllContacts() {
        return contactDao.getAllContacts();
    }

    public void removeContacts(String[] ids) {
        System.out.println("OK");
        for (String id : ids) {
            int idToDelete = Integer.parseInt(id);
            contactDao.remove(idToDelete);
        }
  /*      List<Contact> contactList = getAllContacts();
        for (String id : ids) {
            int idToDelete = Integer.parseInt(id);
            contactList.removeIf(contact -> contact.getId() == idToDelete);
        }*/
    }
}
