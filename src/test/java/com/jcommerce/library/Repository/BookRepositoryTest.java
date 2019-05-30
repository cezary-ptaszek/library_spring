package com.jcommerce.library.Repository;

import static org.junit.Assert.assertEquals;
import java.util.List;
import com.jcommerce.library.Entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testFindAll() {
        List<Book> books = bookRepository.findAll();
        assertEquals(30,books.size());
    }

    @Test
    public void testFindOne() {
        Book book = bookRepository.findById((long)1).get();

        assertEquals("Madame Curie",book.getTitle());
    }

}