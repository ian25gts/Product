package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RepositoryTest {

    private Repository repo = new Repository();
    private Product book1 = new Book(1, "Красный", 100, "Иванов");
    private Product book2 = new Book(2, "Синий", 200, "Петров");
    private Product book3 = new Book(3, "Синий", 300, "Сидоров");
    private Product smartphone1 = new Smartphone(4, "Note 12", 20000, "Xiaomi");
    private Product smartphone2 = new Smartphone(5, "Note 12 pro", 30000, "Xiaomi");

    @Test
    public void saveOneBook() {
        repo.save(book1);

        Product[] expected = new Product[]{book1};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void saveOneSmartphone() {
        repo.save(smartphone1);

        Product[] expected = new Product[]{smartphone1};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void saveBookAndSmartphone() {
        repo.save(book1);
        repo.save(smartphone1);

        Product[] expected = new Product[]{book1, smartphone1};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findZero() {
        repo.findAll();

        Product[] expected = new Product[]{};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findOneBook() {
        repo.save(book1);

        repo.findAll();

        Product[] expected = new Product[]{book1};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findOneSmartphone() {
        repo.save(smartphone1);

        repo.findAll();

        Product[] expected = new Product[]{smartphone1};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findBookAndSmartphone() {
        repo.save(book1);
        repo.save(smartphone1);

        repo.findAll();

        Product[] expected = new Product[]{book1, smartphone1};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeBookById() {
        repo.save(book1);

        repo.removeById(1);

        Product[] expected = new Product[]{};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeSmartphoneById() {
        repo.save(smartphone1);

        repo.removeById(4);

        Product[] expected = new Product[]{};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeBookAndSmartphoneById() {
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);

        repo.removeById(2);
        repo.removeById(4);

        Product[] expected = new Product[]{book1, smartphone2};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeNonId() {
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);

        repo.removeById(6);

        Product[] expected = {book1, book2, book3, smartphone1, smartphone2};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }
}