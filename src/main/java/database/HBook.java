package database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class HBook {

    public static List<Book> getAll() {
        EntityManagerFactory entityManagerFactory = SessionFactory.getEntityManagerFactory();
        EntityManager manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        List<Book> books = manager.createQuery("from Book", Book.class).getResultList();
        manager.getTransaction().commit();
        manager.close();
        return books;
    }

    public static void save(Book book) {
        EntityManagerFactory entityManagerFactory = SessionFactory.getEntityManagerFactory();
        EntityManager manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(book);
        manager.getTransaction().commit();
        manager.close();
    }

    public static void update(Book book) {
        EntityManagerFactory entityManagerFactory = SessionFactory.getEntityManagerFactory();
        EntityManager manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        manager.merge(book);
        manager.getTransaction().commit();
        manager.close();
    }

    public static void delete(Book book) {
        EntityManagerFactory entityManagerFactory = SessionFactory.getEntityManagerFactory();
        EntityManager manager = entityManagerFactory.createEntityManager();
        Book book1 = manager.find(Book.class, book.getId());
        manager.getTransaction().begin();
        manager.remove(book1);
        manager.getTransaction().commit();
        manager.close();
    }

    public static Book findById(Long id) {
        EntityManagerFactory entityManagerFactory = SessionFactory.getEntityManagerFactory();
        EntityManager manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        Book book = manager.find(Book.class, id);
        manager.getTransaction().commit();
        manager.close();
        return book;
    }


}
