package com.andersonhelder.gerenciador.dto.enderecos;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

public class EnderecoPrincipalDTO {
	
	@NotNull(message = "O pessoa_id é obrigatório")
	@Range(min=1)
	private long pessoa_id;
	
	@NotNull(message = "O endereco_id é obrigatório")
	@Range(min=1)
	private long endereco_id;

	public long getPessoa_id() {
		return pessoa_id;
	}

	public void setPessoa_id(long pessoa_id) {
		this.pessoa_id = pessoa_id;
	}

	public long getEndereco_id() {
		return endereco_id;
	}

	public void setEndereco_id(long endereco_id) {
		this.endereco_id = endereco_id;
	}
	
	

}
