package ua.thecoon.lawsys.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomRepo {
    private final EntityManager entityManager;

    public List executeQuery(String jpql) {
        Query query = entityManager.createQuery(jpql);
        return query.getResultList();
    }

    public List executeNativeQuery(String sql) {
        Query query = entityManager.createNativeQuery(sql);
        return query.getResultList();
    }
}
