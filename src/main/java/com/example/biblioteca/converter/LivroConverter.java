package com.example.biblioteca.converter;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.request.LivroRequest;
import org.springframework.stereotype.Component;

@Component
public class LivroConverter {

    public Livro convertToLivro(LivroRequest livroRequest){
        Livro livro = new Livro();
        livro.setNome(livroRequest.getNome());
        livro.setAutor(livroRequest.getAutor());
        return livro;
    }
}
