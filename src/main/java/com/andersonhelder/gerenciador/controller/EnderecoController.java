package com.andersonhelder.gerenciador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andersonhelder.gerenciador.dto.enderecos.EnderecoDTO;
import com.andersonhelder.gerenciador.models.Endereco;
import com.andersonhelder.gerenciador.service.EnderecoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
@Api(value="API REST Gerenciador")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@ApiOperation(value="Retorno de um endereco")
	@GetMapping(value="/endereco/{id}")
	public ResponseEntity<Endereco> buscarEnderecoPorId(@PathVariable long id){
		Endereco endereco = enderecoService.buscarEnderecoPorId(id);
		return ResponseEntity.ok().body(endereco);
	}
	
	@ApiOperation(value="Retorno de todos os enderecos cadastrados de uma pessoa")
	@GetMapping(value="/pessoaenderecos/{id}")
	public ResponseEntity<List<Endereco>> buscarEnderecosPessoas(@PathVariable long id){
		return ResponseEntity.ok().body(enderecoService.listarEnderecoPessoas(id));
	}
	
	@ApiOperation(value="Adiciona um endereco")
	@PostMapping(value = "/endereco")
	public Endereco salvarEndereco(@RequestBody EnderecoDTO endereco) {
		return enderecoService.salvarEndereco(endereco);
	}
	
	
}
