package com.example.biblioteca.Controller;

import com.example.biblioteca.Model.Libro;
import com.example.biblioteca.Service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libros")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @PostMapping
    public Libro create(@RequestBody Libro libro) {
        return libroService.save(libro);
    }

    @GetMapping("/{id}")
    public Optional<Libro> getById(@PathVariable Long id) {
        return libroService.findById(id);
    }

    @GetMapping
    public List<Libro> getAll() {
        return libroService.findAll();
    }

    @PutMapping("/{id}")
    public Libro update(@PathVariable Long id, @RequestBody Libro libro) {
        libro.setId(id);
        return libroService.save(libro);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        libroService.deleteById(id);
    }
}