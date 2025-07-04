package com.techwaala;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SqlExecutor {

    private EntityManager entityManager;

    public SqlExecutor() {
    }

    @Autowired
    public SqlExecutor(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<?> execute(String query) {
        List<?> result = entityManager
                .createNativeQuery(query)
                .getResultList();
        if (result.isEmpty()) {
            throw new EmptyResultException("No results found for the provided query.");
        }
        return result;
    }
}
