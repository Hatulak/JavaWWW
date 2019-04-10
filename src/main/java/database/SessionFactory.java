package database;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SessionFactory {
    private static EntityManagerFactory entityManagerFactory;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("javaWWW");
        }
        return entityManagerFactory;
    }
}
