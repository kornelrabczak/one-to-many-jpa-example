package com.thecookiezen.one2manyexample.unidirectional.sort.control;

import com.thecookiezen.one2manyexample.unidirectional.sort.entity.GameSort;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class GameSortService {

    @PersistenceContext
    EntityManager entityManager;

    public void saveNewEntity(GameSort game) {
        entityManager.persist(game);
    }

    public List<GameSort> getAll() {
        return entityManager.createQuery("SELECT _gameSort FROM GameSort _gameSort", GameSort.class).getResultList();
    }
}
