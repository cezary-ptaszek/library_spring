package com.jcommerce.library.Services;

import com.jcommerce.library.DAO.ReaderDAO;
import com.jcommerce.library.Entity.Reader;
import com.jcommerce.library.Repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReaderService implements ReaderDAO {

    private ReaderRepository readerRepository;

    @Autowired
    public ReaderService(ReaderRepository readerRepository){
        this.readerRepository = readerRepository;
    }

    @Override
    public List<Reader> findAll() {
        return readerRepository.findAll();
    }

    @Override
    public Optional<Reader> findById(Long id) {
        return readerRepository.findById(id);
    }

    @Override
    public Reader save(Reader reader) {
        return readerRepository.save(reader);
    }

    @Override
    public void deleteById(Long id) {
        readerRepository.deleteById(id);
    }
}