package com.example.biblioteca.Service;

import com.example.biblioteca.Model.Autor;
import com.example.biblioteca.Repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }

    public Optional<Autor> findById(Long id) {
        return autorRepository.findById(id);
    }

    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    public void deleteById(Long id) {
        autorRepository.deleteById(id);
    }
}