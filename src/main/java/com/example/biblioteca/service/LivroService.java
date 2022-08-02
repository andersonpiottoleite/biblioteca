package com.example.biblioteca.service;

import com.example.biblioteca.bo.LivroBusinessObject;
import com.example.biblioteca.exception.LivroException;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroBusinessObject livroBusinessObject;

    @Autowired
    private LivroRepository livroRepository;
    public Livro save(Livro livro) {
        livroBusinessObject.validaLivro(livro);
        Livro livroSalvo = livroRepository.save(livro);
        return livroSalvo;
    }

    public List<Livro> findAll() {
        //return livroRepository.findAll();
        return livroRepository.findByOrderByNomeAsc();
    }

    public Livro findById(Long id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new LivroException
                        ("Livro Não encontrado para o id: " + id));
    }

    public Livro update(Livro livro) {
        return livroRepository.save(livro);
    }

    public void delete(Long id) {
        livroRepository.deleteById(id);
    }
}
