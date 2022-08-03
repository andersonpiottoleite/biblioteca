package com.example.biblioteca.model;

import com.example.biblioteca.enumeracao.TipoMatriculaEnum;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private int idade;
    @Enumerated(EnumType.STRING)
    private TipoMatriculaEnum tipoMatricula;

}
