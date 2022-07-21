package com.andersonhelder.gerenciador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.andersonhelder.gerenciador.dto.EnderecoDTO;
import com.andersonhelder.gerenciador.models.Endereco;
import com.andersonhelder.gerenciador.models.Pessoa;
import com.andersonhelder.gerenciador.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PessoaService pessoaService;

	public Endereco buscarEnderecoPorId(long id) {
		Endereco endereco = enderecoRepository.findById(id);
		return endereco;
	}

	public List<Endereco> listarEnderecoPessoas(Long id) {
		Pessoa pessoa2 = pessoaService.buscarPorId(id);
		return enderecoRepository.findByPessoa(pessoa2);
	}

	public Endereco salvarEndereco(@RequestBody EnderecoDTO endereco) {
		Endereco endereco2 = new Endereco();
		endereco2.setLogradouro(endereco.getLogradouro());
		endereco2.setCep(endereco.getCep());
		endereco2.setCidade(endereco.getCidade());
		endereco2.setNumero(endereco.getNumero());
		Pessoa pessoa = pessoaService.buscarPorId(endereco.getPessoa_id());
		if(pessoa != null) {
			endereco2.setPessoa(pessoa);
		}
		else {
			return null;
		}
		return enderecoRepository.save(endereco2);
	}
	
}
