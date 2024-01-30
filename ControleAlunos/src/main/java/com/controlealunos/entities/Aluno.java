package com.controlealunos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "funcionario")
public class Aluno {
	
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NotNull
		@NotBlank
		private String nome;
		
		
		@NotNull
		private String cpf;
		
		@NotNull
		private String rg;
		
		@NotNull
		private String endereco;

	}


