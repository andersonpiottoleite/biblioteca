package com.example.biblioteca.request;

import com.example.biblioteca.enumeracao.TipoMatriculaEnum;
import lombok.Data;

@Data
public class AlunoSaveRequest {

    private String nome;
    private int idade;
    private TipoMatriculaEnum tipoMatricula;

}
