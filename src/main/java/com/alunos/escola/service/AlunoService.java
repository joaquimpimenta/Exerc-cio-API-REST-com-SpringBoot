package com.alunos.escola.service;

import com.alunos.escola.model.Aluno;
import com.alunos.escola.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno criarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public List<Aluno> listarAluno(){
        return alunoRepository.findAll();
    }

    public Aluno buscarPorID(Long id){
        return alunoRepository.findById(id).orElse(null);
    }

    public Aluno removerAluno(Long id){
        return alunoRepository.getReferenceById(id);
    }

}
