package com.example.biblioteca.repository;

import com.example.biblioteca.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
