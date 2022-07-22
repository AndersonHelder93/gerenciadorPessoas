package com.andersonhelder.gerenciador.dto.pessoas;

import javax.validation.constraints.NotBlank;

public class PessoaDTO {

	@NotBlank(message="Campo nome obrigatório")
	private String nome;

	@NotBlank(message="Campo data de nascimento obrigatório")
	private String dataNascimento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
}
