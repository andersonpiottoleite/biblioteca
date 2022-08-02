package com.example.biblioteca.controller;

import com.example.biblioteca.converter.LivroConverter;
import com.example.biblioteca.exception.LivroException;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.request.LivroSaveRequest;
import com.example.biblioteca.request.LivroUpdateResquest;
import com.example.biblioteca.response.LivroResponse;
import com.example.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

   // 200 - OK
   // 201 - Created
   // 204 - NoContent
   // 400 - BadRequest
   // 404 - NotFound
   // 403 - ForBidden
   // 500 - Internal Server Error

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
   public ResponseEntity<LivroResponse> save(@RequestBody LivroSaveRequest livroSaveRequest){
      try {
         Livro livro = livroConverter.convertToLivro(livroSaveRequest);

         Livro livroSalvo = livroService.save(livro);

         LivroResponse livroResponse = livroConverter.convertToLivroResponse(livroSalvo);

         UriComponents uriComponents = UriComponentsBuilder.newInstance()
                 .scheme("http").host("localhost:8080")
                 .path("/biblioteca").path("/livros/"+livroResponse.getId()).build();

         return ResponseEntity.created(
                 new URI(uriComponents.toUriString())).build();

      } catch (LivroException e){
         return ResponseEntity.badRequest().build();

      } catch (Exception e){
         return ResponseEntity.internalServerError().build();
      }
   }

   @PutMapping
   public ResponseEntity<LivroResponse> update(@RequestBody LivroUpdateResquest livroUpdateResquest){
      try {
         Livro livro  = livroConverter.convertToLivro(livroUpdateResquest);

         Livro livroAlterado = livroService.update(livro);

         LivroResponse livroResponse = livroConverter.convertToLivroResponse(livroAlterado);

         return ResponseEntity.ok().build();

      }catch (Exception e){
         return ResponseEntity.internalServerError().build();
      }
   }

   @GetMapping
   public ResponseEntity<List<LivroResponse>> findAll(){
      try {
         List<Livro> livros = livroService.findAll();

         List<LivroResponse> livrosResponse = livroConverter.convertToListLivroResponse(livros);

         return ResponseEntity.ok(livrosResponse);

      } catch (Exception e){
         return ResponseEntity.internalServerError().build();
      }
   }

   @GetMapping("/{id}")
   public ResponseEntity<LivroResponse> findById(@PathVariable Long id){
      try {
         Livro livro = livroService.findById(id);

         LivroResponse livroResponse = livroConverter.convertToLivroResponse(livro);

         return ResponseEntity.ok(livroResponse);

      } catch (LivroException e){
         return ResponseEntity.noContent().build();

      } catch (Exception e){
         return ResponseEntity.internalServerError().build();
      }
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<?> delete(@PathVariable Long id){
      try {
         livroService.delete(id);
         return ResponseEntity.ok().build();
      }catch (Exception e){
         return ResponseEntity.internalServerError().build();
      }
   }
}
