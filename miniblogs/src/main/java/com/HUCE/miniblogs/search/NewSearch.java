package com.HUCE.miniblogs.search;

import com.HUCE.miniblogs.entity.NewEntity;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.BooleanJunction;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class NewSearch {
    private static final String NEW_NAME = "name";

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    public NewSearch(EntityManager entityManager,
                          EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManager;
        this.entityManagerFactory = entityManagerFactory;
    }

    public List<NewEntity> searchProperty(String searchtitle) {

        entityManager = entityManagerFactory.createEntityManager();

        FullTextEntityManager fullTextEntityManager = initializedFullTextEntityManager();

        QueryBuilder qb = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder().forEntity(NewEntity.class ).get();

        BooleanJunction<BooleanJunction> booleanJunction =
                HibernateSearchUtil.buildBooleanJunctionSearch(
                        qb,
                        searchtitle,
                        NEW_NAME
                );

        FullTextQuery query =
                fullTextEntityManager.createFullTextQuery(booleanJunction.createQuery(), NewEntity.class);

        List<NewEntity> newEntities = query.getResultList();

        commitTransaction();

        return newEntities;
    }

    private FullTextEntityManager initializedFullTextEntityManager() {

        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);

        entityManager.getTransaction().begin();

        return fullTextEntityManager;
    }

    private void commitTransaction() {
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
