package com.andersonhelder.gerenciador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andersonhelder.gerenciador.dto.enderecos.EnderecoPrincipalDTO;
import com.andersonhelder.gerenciador.dto.pessoas.EditarPessoaDTO;
import com.andersonhelder.gerenciador.dto.pessoas.PessoaDTO;
import com.andersonhelder.gerenciador.models.Pessoa;
import com.andersonhelder.gerenciador.service.PessoaService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@ApiOperation(value="Retorno de uma pessoa")
	@GetMapping(value="/pessoa/{id}")
	public ResponseEntity<Pessoa> buscarPorId(@PathVariable Long id){
		Pessoa pessoa = pessoaService.buscarPorId(id);
		return ResponseEntity.ok().body(pessoa);
	}
	
	@ApiOperation(value="Retorno de uma lista de pessoas")
	@GetMapping(value="/pessoas")
	public ResponseEntity<List<Pessoa>> buscarPessoas(){
		return ResponseEntity.ok().body(pessoaService.listarPessoas());
	}

	@ApiOperation(value="Adiciona uma pessoa ")
	@PostMapping(value = "/pessoa")
	public Pessoa salvarPessoa(@RequestBody PessoaDTO pessoa) {
		return pessoaService.salvarPessoa(pessoa);
	}
	
	@ApiOperation(value="Editar uma pessoa")
	@PutMapping(value = "/pessoa/{id}")
	public Pessoa editar(@PathVariable long id, @RequestBody EditarPessoaDTO npessoa){
		return pessoaService.editarPessoa(id, npessoa);
		
	}
	
	@ApiOperation(value="Atribui um endereco principal a uma pessoa")
	@PutMapping(value = "/enderecoprincipal")
	public Pessoa salvarEndereco(@RequestBody EnderecoPrincipalDTO endereco) {
		return pessoaService.salvarEnderecoPrincipal(endereco);
	}
}
