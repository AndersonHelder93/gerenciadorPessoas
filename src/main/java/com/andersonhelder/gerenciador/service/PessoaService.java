package com.andersonhelder.gerenciador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersonhelder.gerenciador.dto.enderecos.EnderecoPrincipalDTO;
import com.andersonhelder.gerenciador.dto.pessoas.EditarPessoaDTO;
import com.andersonhelder.gerenciador.dto.pessoas.PessoaDTO;
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

	public Pessoa salvarPessoa(PessoaDTO pessoa) {
		Pessoa novaPessoa = new Pessoa();
		novaPessoa.setNome(pessoa.getNome());
		novaPessoa.setDataNascimento(pessoa.getDataNascimento());
		return pessoaRepository.save(novaPessoa);
	}

	public Pessoa editarPessoa(long id, EditarPessoaDTO npessoa) {
		Pessoa data = pessoaRepository.findById(id);
		if (data == null) {
			return null;
		}
		data.setNome(npessoa.getNome());
		data.setDataNascimento(npessoa.getDataNascimento());
		return pessoaRepository.save(data);

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
		if(endereco2.getPessoa().equals(pessoa) ) {
			pessoa.setEnderecoPrincipal(endereco2);
			return pessoaRepository.save(pessoa);
		}
		return null;
		
	}
}
