package ru.academits.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.academits.controller.PhoneBookController;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Transactional
public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {
    private static final Logger logger = LoggerFactory.getLogger(PhoneBookController.class);

    @Autowired
    private SessionFactory sessionFactory;

    protected Class<T> clazz;

    public GenericDaoImpl(Class<T> type) {
        this.clazz = type;
    }

    @Transactional
    @Override
    public void saveOrUpdate(T obj) {
        sessionFactory.getCurrentSession().saveOrUpdate(obj);
    }

    @Override
    public T getById(PK id) {
        return (T) sessionFactory.getCurrentSession().get(clazz, id);
    }


    @Transactional
    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAllByMulti(Map<String, Object> condition, String name, boolean value) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clazz);
        Criterion cr1 = Restrictions.eq(name, value);
        condition.forEach((k, v) -> {
            if (k != null) {
                Criterion cr2 = Restrictions.eq(k, v);
                LogicalExpression andExp = Restrictions.and(cr1, cr2);
                criteria.add(andExp);
            }
        });
        return (List<T>) criteria.list();
    }

    @Transactional
    @Override
    public List<T> findAll(String name, boolean value) {
        return findAll(null, name, value);
    }

    @Transactional
    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll(Order order, String name, boolean value) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clazz);
        if (order != null) {
            criteria.addOrder(order);
        }
        criteria.add(Restrictions.eq(name, value));
        return (List<T>) criteria.list();
    }
}
