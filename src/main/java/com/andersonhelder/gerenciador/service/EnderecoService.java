package com.andersonhelder.gerenciador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.andersonhelder.gerenciador.models.Endereco;
import com.andersonhelder.gerenciador.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	public Endereco buscarEnderecoPorId(long id) {
		Endereco endereco = enderecoRepository.findById(id);
		return endereco;
	}

	public List<Endereco> listarEnderecoPessoas() {
		return enderecoRepository.findAll();
	}

	public Endereco salvarEndereco(@RequestBody Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
}
