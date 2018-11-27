package ru.academits.dao;

import org.springframework.stereotype.Repository;
import ru.academits.model.Contact;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ContactDaoImpl extends GenericDaoImpl<Contact, Integer> implements ContactDao {

    public ContactDaoImpl() {
        super(Contact.class);
    }

    @Override
    public List<Contact> getAllContacts() {
        String name = "removed";
        boolean value = false;
        return findAll(name, value);
    }

    @Override
    public void add(Contact contact) {
        saveOrUpdate(contact);
    }

    @Override
    public void remove(int id) {
        Contact contactToDelete = getById(id);
        contactToDelete.setRemoved();
        saveOrUpdate(contactToDelete);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Contact> findByPhone(String phone) {
        Map condition = new HashMap<String, Object>();
        condition.put("phone", phone);
        String name = "removed";
        boolean value = false;
        return findAllByMulti(condition, name, value);
    }
}
