package com.example.biblioteca.converter;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.request.LivroSaveRequest;
import com.example.biblioteca.request.LivroUpdateResquest;
import com.example.biblioteca.response.LivroResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LivroConverter {

    public Livro convertToLivro(LivroSaveRequest livroSaveRequest){
        Livro livro = new Livro();
        livro.setNome(livroSaveRequest.getNome());
        livro.setAutor(livroSaveRequest.getAutor());
        return livro;
    }

    public Livro convertToLivro(LivroUpdateResquest livroUpdateResquest){
        Livro livro = new Livro();
        livro.setId(livroUpdateResquest.getId());
        livro.setNome(livroUpdateResquest.getNome());
        livro.setAutor(livroUpdateResquest.getAutor());
        return livro;
    }

    public LivroResponse convertToLivroResponse(Livro livro){
        LivroResponse livroResponse = new LivroResponse();
        livroResponse.setId(livro.getId());
        livroResponse.setNome(livro.getNome());
        livroResponse.setAutor(livro.getAutor());
        return livroResponse;
    }

    public List<LivroResponse> convertToListLivroResponse(List<Livro> livros) {

        /*List<LivroResponse> livrosResponse = livros.stream().map(livro -> {
            LivroResponse livroResponse = new LivroResponse();
            livroResponse.setId(livro.getId());
            livroResponse.setNome(livro.getNome());
            livroResponse.setAutor(livro.getAutor());
            return livroResponse;

        }).collect(Collectors.toList());*/

        List<LivroResponse> livrosResponse = livros
                .stream()
                .map(this::convertToLivroResponse)
                .collect(Collectors.toList());

        return livrosResponse;
    }
}
