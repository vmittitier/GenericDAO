package com.invillia.generic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    public static void main(String[] args) {
        final EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("genericSample");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        final ContactDAO contactDAO = new ContactDAO(entityManager);
        final CarDAO carDAO = new CarDAO(entityManager);

        Contact contact = new Contact("Vini","vini@vini.com");
        contactDAO.insert(contact);

        Car car = new Car("Fiesta",2004);
        carDAO.insert(car);
    }
}
