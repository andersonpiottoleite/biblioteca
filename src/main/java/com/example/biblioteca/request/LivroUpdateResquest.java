package com.example.biblioteca.request;

import lombok.Data;

@Data
public class LivroUpdateResquest {

    private Long id;
    private String nome;
    private String autor;

}
