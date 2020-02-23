package com.jcommerce.library.DAO;

import com.jcommerce.library.Entity.Reader;

import java.util.List;
import java.util.Optional;

public interface ReaderDAO {

    List<Reader> findAll();

    Optional<Reader> findById(Long id);

    Reader save(Reader reader);

    void deleteById(Long id);

}