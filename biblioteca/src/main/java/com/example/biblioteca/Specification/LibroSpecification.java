package com.example.biblioteca.Specification;

import com.example.biblioteca.Model.Libro;
import org.springframework.data.jpa.domain.Specification;

public class LibroSpecification {
    public static Specification<Libro> hasTitulo(String titulo) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("titulo"), titulo);
    }
}