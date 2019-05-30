package com.jcommerce.library.Services;

import com.jcommerce.library.Entity.Reader;

import java.util.List;
import java.util.Optional;

public interface IReaderService {

    public List<Reader> findAll();

    public Optional<Reader> findById(Long id);

    public Reader save(Reader reader);

    public void deleteById(Long id);

}