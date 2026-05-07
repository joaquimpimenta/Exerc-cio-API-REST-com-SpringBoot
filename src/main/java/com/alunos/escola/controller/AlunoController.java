package com.alunos.escola.controller;


import com.alunos.escola.service.AlunoService;
import com.alunos.escola.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno aluno) {
        Aluno novoAluno = alunoService.criarAluno(aluno);
        return ResponseEntity.ok(novoAluno);
    }

    @GetMapping("/listar")
    public List<Aluno> listarAlunos() {
        return alunoService.listarAluno();
    }

    @GetMapping("/aluinos/{id}")
    public ResponseEntity<Aluno> buscarAlunoPorId(@PathVariable Long id) {
        Aluno aluno = alunoService.buscarPorID(id);
        if (aluno != null) {
            return ResponseEntity.ok(aluno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/alunos/{id}")
    public ResponseEntity<Aluno> deletar(@PathVariable Long id) {
        alunoService.removerAluno(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/alunos/{id}")
    public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody Aluno aluno) {
        Aluno alunoExistente = alunoService.buscarPorID(id);
        if (alunoExistente != null) {
            alunoExistente.setNome(aluno.getNome());
            alunoExistente.setCurso(aluno.getCurso());
            alunoExistente.setMatricula(aluno.getMatricula());
            Aluno alunoAtualizado = alunoService.criarAluno(alunoExistente);
            return ResponseEntity.ok(alunoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
