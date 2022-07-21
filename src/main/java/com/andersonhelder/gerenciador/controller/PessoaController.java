package com.andersonhelder.gerenciador.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andersonhelder.gerenciador.dto.EnderecoPrincipalDTO;
import com.andersonhelder.gerenciador.models.Pessoa;
import com.andersonhelder.gerenciador.service.PessoaService;

@RestController
@RequestMapping("/api")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping(value="/pessoa/{id}")
	public ResponseEntity<Pessoa> buscarPorId(@PathVariable Long id){
		Pessoa pessoa = pessoaService.buscarPorId(id);
		return ResponseEntity.ok().body(pessoa);
	}
	
	@GetMapping(value="/pessoas")
	public ResponseEntity<List<Pessoa>> buscarPessoas(){
		return ResponseEntity.ok().body(pessoaService.listarPessoas());
	}

	@PostMapping(value = "/inserir/pessoa")
	public Pessoa salvarPessoa(@RequestBody Pessoa pessoa) {
		return pessoaService.salvarPessoa(pessoa);
	}
	
	@PutMapping(value = "/pessoa/{id}")
	@Transactional
	public Pessoa editar(@PathVariable long id, @RequestBody Pessoa npessoa){
		return pessoaService.editarPessoa(id, npessoa);
		
	}
	
	@PutMapping(value = "/inserir/enderecoprincipal")
	public Pessoa salvarEndereco(@RequestBody EnderecoPrincipalDTO endereco) {
		return pessoaService.salvarEnderecoPrincipal(endereco);
	}
}
