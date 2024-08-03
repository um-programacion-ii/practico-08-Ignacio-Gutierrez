package com.example.biblioteca.Service;

import com.example.biblioteca.Model.Libro;
import com.example.biblioteca.Repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }

    public Optional<Libro> findById(Long id) {
        return libroRepository.findById(id);
    }

    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    public void deleteById(Long id) {
        libroRepository.deleteById(id);
    }

    public List<Libro> findByTitulo(String titulo) {
        return libroRepository.findByTitulo(titulo);
    }
}