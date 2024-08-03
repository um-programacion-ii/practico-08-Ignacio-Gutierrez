package com.example.biblioteca.Repository;

import com.example.biblioteca.Model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByTitulo(String titulo);

    @Query("SELECT l FROM Libro l WHERE l.titulo = :titulo")
    List<Libro> buscarPorTitulo(String titulo);
}