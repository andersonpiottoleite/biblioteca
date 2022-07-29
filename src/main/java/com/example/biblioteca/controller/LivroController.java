package com.example.biblioteca.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroController {

   @PostMapping
   public Livro save(Livro livro){
      return new Livro();
   }
}
