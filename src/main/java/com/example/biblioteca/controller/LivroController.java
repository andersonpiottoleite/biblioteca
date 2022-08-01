package com.example.biblioteca.controller;

import com.example.biblioteca.converter.LivroConverter;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.request.LivroSaveRequest;
import com.example.biblioteca.request.LivroUpdateResquest;
import com.example.biblioteca.response.LivroResponse;
import com.example.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

   // @Autowired
   private LivroService livroService;


   //@Autowired
   private LivroConverter livroConverter;

   @Autowired
   public LivroController(LivroService livroService, LivroConverter livroConverter){
      this.livroService = livroService;
      this.livroConverter = livroConverter;
   }

   @PostMapping
   public LivroResponse save(@RequestBody LivroSaveRequest livroSaveRequest){
         Livro livro = livroConverter.convertToLivro(livroSaveRequest);

         Livro livroSalvo = livroService.save(livro);

         LivroResponse livroResponse = livroConverter.convertToLivroResponse(livroSalvo);

         return livroResponse;
   }

   @PutMapping
   public Livro update(@RequestBody LivroUpdateResquest livroUpdateResquest){
      Livro livro  = livroConverter.convertToLivro(livroUpdateResquest);

      Livro livroAlterado = livroService.update(livro);

      LivroResponse livroResponse = livroConverter.convertToLivroResponse(livroAlterado);

      return livroAlterado;
   }

   @GetMapping
   public List<LivroResponse> findAll(){
      List<Livro> livros = livroService.findAll();

      List<LivroResponse> livrosResponse = livroConverter.convertToListLivroResponse(livros);

      return livrosResponse;
   }

   @GetMapping("/{id}")
   public LivroResponse findById(@PathVariable Long id){
      Livro livro = livroService.findById(id);
      LivroResponse livroResponse = livroConverter.convertToLivroResponse(livro);
      return livroResponse;
   }

   @DeleteMapping("/{id}")
   public void delete(@PathVariable Long id){
      livroService.delete(id);
   }
}
