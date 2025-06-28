package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entity.Author;
import org.example.entity.Book;
import org.example.entity.Category;
import org.example.entity.Publisher;

import java.time.LocalDate;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LibraryManagement");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            // Author oluştur
            Author author = new Author();
            author.setName("Halit Ziya Uşaklıgil");
            author.setBirthDate(LocalDate.of(1866, 2, 22));
            author.setCountry("Türkiye");
            entityManager.persist(author);

            // Publisher oluştur
            Publisher publisher = new Publisher();
            publisher.setName("Servet-i Fünun Yayıncılık");
            publisher.setAddress("İstanbul");
            publisher.setEstablishmentYear(LocalDate.of(1900, 1, 1));
            entityManager.persist(publisher);

            // Category oluştur
            Category category = new Category();
            category.setName("Klasik Roman");
            category.setDescription("Tanzimat sonrası klasik Türk romanları");
            entityManager.persist(category);

            // Book oluştur
            Book book = new Book();
            book.setName("Aşk-ı Memnu");
            book.setPublicationYear(LocalDate.of(1899, 1, 1));
            book.setStock(10);
            book.setAuthor(author);
            book.setPublisher(publisher);
            book.getCategory(Collections.singletonList(category));
            book.setMail("demo@example.com"); // unique constraint varsa benzersiz yap
            entityManager.persist(book);

            entityManager.getTransaction().commit();
            System.out.println("Veriler başarıyla eklendi.");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}