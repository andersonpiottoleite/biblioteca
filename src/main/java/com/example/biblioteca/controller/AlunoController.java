package com.example.biblioteca.controller;

import com.example.biblioteca.model.Aluno;
import com.example.biblioteca.request.AlunoSaveRequest;
import com.example.biblioteca.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;
    // 1 - http://localhost:8080/biblioteca/aluno/form
    @GetMapping("form")
    public String getFormCadastro(/*Model model*/){
        //model.addAttribute("alunoRequest", new AlunoSaveRequest());
        return "cadastro-aluno";
    }


    // 2
    @PostMapping("cadastrar")
    public String cadastroAluno(/*@ModelAttribute */AlunoSaveRequest alunoRequest, Model model){

        Aluno aluno = new Aluno();
        aluno.setNome(alunoRequest.getNome());
        aluno.setIdade(alunoRequest.getIdade());
        aluno.setTipoMatricula(alunoRequest.getTipoMatricula());
        alunoService.save(aluno);
        List<Aluno> alunos = alunoService.findAll();
        model.addAttribute("alunos", alunos);

        return "lista-alunos";
    }
}
