package com.faculdade.faculdade.services;

import com.faculdade.faculdade.entities.Aluno;
import com.faculdade.faculdade.entities.Pessoa;
import com.faculdade.faculdade.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaculdadeService {
    @Autowired
    AlunoRepository alunoRepository;

    public Aluno findById(Integer ra) {
        Optional<Aluno> aluno = alunoRepository.findById((ra));
        return aluno.orElse(null);
    }

    public List<Aluno> listarTodosAbertos() {
        List<Aluno> alunos = alunoRepository.listarTodosAbertos();
        return alunos;
    }

    public List<Aluno> listarTodosFechados() {
        List<Aluno> alunos = alunoRepository.listarTodosFechados();
        return alunos;
    }

    public List<Aluno> findAll() {
        List<Aluno> alunos = alunoRepository.findAll();
        return alunos;
    }

    public Aluno findByNome(String nome) {
        Optional <Aluno> aluno = alunoRepository.findByNome(nome);
        return aluno.orElse(null);
    }

    public Aluno gravarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public void deletar(Integer ra) {
        alunoRepository.deleteById(ra);
    }

    public Aluno updateAluno(Integer ra, Aluno aluno) {
        Aluno alterado = findById(ra);
        if(alterado != null) {
            alterado.setNome(aluno.getNome());
            alterado.setDataCadastro(aluno.getDataCadastro());
            alterado.setAtivo(aluno.getAtivo());

        }
        return alunoRepository.save(alterado);
    }

}
