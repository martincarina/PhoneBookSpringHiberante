package ru.academits.dao;

import org.hibernate.criterion.Order;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface GenericDao<T, PK extends Serializable> {

    @Transactional
    void saveOrUpdate(T obj);

    T getById(PK id);

    List<T> findAllByMulti(Map<String, Object> condition, String name, boolean value);

    @Transactional
    List<T> findAll(String name, boolean value);

    @Transactional
    @SuppressWarnings("unchecked")
    List<T> findAll(Order order, String name, boolean value);
}
