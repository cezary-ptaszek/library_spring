package com.jcommerce.library.Repository;

import com.jcommerce.library.Entity.Reader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@RunWith(SpringRunner.class)
@DataJpaTest
public class ReaderRepositoryTest {

    @Autowired
    private ReaderRepository readerRepository;

    @Test
    public void testFindAll() {
        List<Reader> readers = readerRepository.findAll();
        assertEquals(20,readers.size());
    }

    @Test
    public void testFindOne() {
        Reader reader = readerRepository.findById((long)1).get();

        assertEquals("Gusti",reader.getName());
    }

}