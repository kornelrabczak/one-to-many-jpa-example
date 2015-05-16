package com.thecookiezen.one2manyexample.unidirectional.order.control;

import com.thecookiezen.one2manyexample.unidirectional.order.entity.Game;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class GameService {

    @PersistenceContext
    EntityManager entityManager;


    public void saveNewEntity(String name) {
        Game testEntity = new Game();
        testEntity.setValue(name);
        entityManager.persist(testEntity);
    }

    public List<Game> getAll() {
        return entityManager.createQuery("SELECT _testEntity FROM TestEntity _testEntity", Game.class).getResultList();
    }
}
