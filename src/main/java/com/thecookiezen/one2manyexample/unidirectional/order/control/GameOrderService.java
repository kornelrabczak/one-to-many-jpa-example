package com.thecookiezen.one2manyexample.unidirectional.order.control;

import com.thecookiezen.one2manyexample.unidirectional.order.entity.GameOrder;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class GameOrderService {

    @PersistenceContext
    EntityManager entityManager;


    public void saveNewEntity(GameOrder game) {
        entityManager.persist(game);
    }

    public List<GameOrder> getAll() {
        return entityManager.createQuery("SELECT _gameOrder FROM GameOrder _gameOrder", GameOrder.class).getResultList();
    }
}
