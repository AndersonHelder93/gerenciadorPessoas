package com.andersonhelder.gerenciador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersonhelder.gerenciador.dto.EnderecoPrincipalDTO;
import com.andersonhelder.gerenciador.models.Endereco;
import com.andersonhelder.gerenciador.models.Pessoa;
import com.andersonhelder.gerenciador.repository.EnderecoRepository;
import com.andersonhelder.gerenciador.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public Pessoa buscarPorId(long id) {
		Pessoa pessoa = pessoaRepository.findById(id);
		return pessoa;
	}

	public List<Pessoa> listarPessoas() {
		return pessoaRepository.findAll();
	}

	public Pessoa salvarPessoa(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	public Pessoa editarPessoa( long id, Pessoa npessoa) {
		Pessoa data = pessoaRepository.findById(id);
		if (data == null) {
			return null;
		}
		data.setNome(npessoa.getNome());
		data.setDataNascimento(npessoa.getDataNascimento());
		return salvarPessoa(npessoa);

	}
	
	
	public Pessoa salvarEnderecoPrincipal(EnderecoPrincipalDTO endereco) {
		Pessoa pessoa = pessoaRepository.findById(endereco.getPessoa_id());
		if(pessoa == null) {
			return null;
		}
		Endereco endereco2 =  enderecoRepository.findById(endereco.getEndereco_id());
		if(endereco2 == null) {
			return null;
		}
		pessoa.setEnderecoPrincipal(endereco2);
		return pessoaRepository.save(pessoa);
	}
}
