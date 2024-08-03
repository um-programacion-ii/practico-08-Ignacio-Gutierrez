package com.example.biblioteca.Controller;

import com.example.biblioteca.Model.Autor;
import com.example.biblioteca.Service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autores")
public class AutorController {
    @Autowired
    private AutorService autorService;

    @PostMapping
    public Autor create(@RequestBody Autor autor) {
        return autorService.save(autor);
    }

    @GetMapping("/{id}")
    public Optional<Autor> getById(@PathVariable Long id) {
        return autorService.findById(id);
    }

    @GetMapping
    public List<Autor> getAll() {
        return autorService.findAll();
    }

    @PutMapping("/{id}")
    public Autor update(@PathVariable Long id, @RequestBody Autor autor) {
        autor.setId(id);
        return autorService.save(autor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        autorService.deleteById(id);
    }
}