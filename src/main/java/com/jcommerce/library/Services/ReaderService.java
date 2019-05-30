package com.jcommerce.library.Services;

import com.jcommerce.library.Entity.Reader;
import com.jcommerce.library.Repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReaderService implements IReaderService {

    @Autowired
    private ReaderRepository readerRespository;

    @Override
    public List<Reader> findAll() {
        return readerRespository.findAll();
    }

    @Override
    public Optional<Reader> findById(Long id) {
        return readerRespository.findById(id);
    }

    @Override
    public Reader save(Reader reader) {
        return readerRespository.save(reader);
    }

    @Override
    public void deleteById(Long id) {
        readerRespository.deleteById(id);
    }
}