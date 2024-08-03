package com.example.biblioteca;

import com.example.biblioteca.Model.Autor;
import com.example.biblioteca.Model.Libro;
import com.example.biblioteca.Repository.AutorRepository;
import com.example.biblioteca.Repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public void run(String... args) throws Exception {
        Autor gabrielGarciaMarquez = new Autor("Gabriel García Márquez", "Colombiano");
        gabrielGarciaMarquez.getLibros().add(new Libro("Cien años de soledad", "9780060114183", gabrielGarciaMarquez));
        gabrielGarciaMarquez.getLibros().add(new Libro("El amor en los tiempos del cólera", "9788439735427", gabrielGarciaMarquez));

        Autor jkRowling = new Autor("J.K. Rowling", "Británica");
        jkRowling.getLibros().add(new Libro("Harry Potter and the Sorcerer's Stone", "9788869183157", jkRowling));
        jkRowling.getLibros().add(new Libro("Harry Potter and the Chamber of Secrets", "9788869185182", jkRowling));
        jkRowling.getLibros().add(new Libro("Harry Potter and the Prisoner of Azkaban", "9780439136358", jkRowling));

        Autor georgeOrwell = new Autor("George Orwell", "Británico");
        georgeOrwell.getLibros().add(new Libro("1984", "9780151660346", georgeOrwell));
        georgeOrwell.getLibros().add(new Libro("Animal Farm", "9780151002177", georgeOrwell));

        Autor bramStoker = new Autor("Bram Stoker", "Irlandés");
        bramStoker.getLibros().add(new Libro("Dracula", "9780763625085", bramStoker));

        Autor fScottFitzgerald = new Autor("F. Scott Fitzgerald", "Estadounidense");
        fScottFitzgerald.getLibros().add(new Libro("The Great Gatsby", "9780521402309", fScottFitzgerald));

        autorRepository.save(gabrielGarciaMarquez);
        autorRepository.save(jkRowling);
        autorRepository.save(georgeOrwell);
        autorRepository.save(bramStoker);
        autorRepository.save(fScottFitzgerald);
    }
}