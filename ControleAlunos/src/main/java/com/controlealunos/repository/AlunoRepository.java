package com.controlealunos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controlealunos.entities.Aluno;

public interface AlunoRepository extends JpaRepository <Aluno, Long> {

}
