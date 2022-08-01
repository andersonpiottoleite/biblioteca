package com.example.biblioteca.service;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;
    public Livro save(Livro livro) {
        Livro livroSalvo = livroRepository.save(livro);
        return livroSalvo;
    }

    public List<Livro> findAll() {
        //return livroRepository.findAll();
        return livroRepository.findByOrderByNomeAsc();
    }

    public Livro findById(Long id) {
        return livroRepository.findById(id).get();
    }

    public Livro update(Livro livro) {
        return livroRepository.save(livro);
    }

    public void delete(Long id) {
        livroRepository.deleteById(id);
    }
}
