package ru.academits.dao;

import ru.academits.model.Contact;

import java.util.List;

public interface ContactDao {
    List<Contact> getAllContacts();

    void add(Contact contact);

    void remove(int id);

    List<Contact> findByPhone(String phone);
}
