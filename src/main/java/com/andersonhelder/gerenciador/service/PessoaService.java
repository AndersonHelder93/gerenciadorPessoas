package com.andersonhelder.gerenciador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.andersonhelder.gerenciador.models.Pessoa;
import com.andersonhelder.gerenciador.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa buscarPorId(long id) {
		Pessoa pessoa = pessoaRepository.findById(id);
		return pessoa;
	}

	public List<Pessoa> listarPessoas() {
		return pessoaRepository.findAll();
	}

	public Pessoa salvarPessoa(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	public Pessoa editarPessoa(@PathVariable("id") long id, @RequestBody Pessoa npessoa) {
		Pessoa data = pessoaRepository.findById(id);
		if (data == null) {
			return null;
		}
		data.setNome(npessoa.getNome());
		data.setDataNascimento(npessoa.getDataNascimento());
		return salvarPessoa(npessoa);

	}
}
