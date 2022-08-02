package com.example.biblioteca.bo;

import com.example.biblioteca.exception.LivroException;
import com.example.biblioteca.model.Livro;
import org.springframework.stereotype.Component;

@Component
public class LivroBusinessObject {

    public void validaLivro(Livro livro) {
        if(livro.getNome().isEmpty()){
            throw new LivroException("Nome vazio");
        }
    }
}
