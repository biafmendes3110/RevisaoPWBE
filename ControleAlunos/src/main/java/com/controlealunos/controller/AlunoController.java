package com.controlealunos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlealunos.entities.Aluno;
import com.controlealunos.services.AlunoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionario")
public class AlunoController {
	private final AlunoService alunoService;

	@Autowired
	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;
	}
	@GetMapping("/{id}")
	public ResponseEntity <Aluno> buscaAlunoIdControlId(@PathVariable Long id){
		Aluno aluno = alunoService.buscaAlunoId(id);
		if(aluno!= null) {
			return ResponseEntity.ok(aluno);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/")
	public ResponseEntity<List<Aluno>> buscaTodosAlunoControl() {
		List<Aluno> Aluno = alunoService.buscaTodosAluno();

		return ResponseEntity.ok(Aluno);
	}
	@PostMapping("/")
	public ResponseEntity<Aluno> salvaAlunoControl(@RequestBody @Valid Aluno aluno){
		Aluno salvaAluno = alunoService.salvaAluno(aluno);

		return ResponseEntity.status(HttpStatus.CREATED).body(salvaAluno);

	}
	@PutMapping ("/{id}")
	public ResponseEntity<Aluno> alterarAluno(@PathVariable Long id, @RequestBody @Valid Aluno aluno) {
		Aluno alterarAluno = alunoService.alterarAluno(id,aluno);
		if (alterarAluno  != null) {
			return ResponseEntity.ok(alterarAluno);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaAlunoControl(@PathVariable Long id) {
		boolean apagar = alunoService.apagarAluno(id);
		if(apagar) {
			return ResponseEntity.ok().body("O aluno foi excluído com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
