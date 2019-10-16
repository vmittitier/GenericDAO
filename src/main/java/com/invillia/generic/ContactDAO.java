package com.invillia.generic;

import javax.persistence.EntityManager;

public class ContactDAO extends GenericDAO<Contact>{

    public ContactDAO(EntityManager entityManager) {
        super(entityManager, Contact.class);
    }


}
