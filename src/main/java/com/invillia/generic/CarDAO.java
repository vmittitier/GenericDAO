package com.invillia.generic;

import javax.persistence.EntityManager;

public class CarDAO extends GenericDAO<Car> {
    public CarDAO(EntityManager entityManager) {
        super(entityManager, Car.class);
    }
}
