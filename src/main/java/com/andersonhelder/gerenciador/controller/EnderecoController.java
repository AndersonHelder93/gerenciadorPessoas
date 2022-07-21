package com.andersonhelder.gerenciador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andersonhelder.gerenciador.dto.EnderecoDTO;
import com.andersonhelder.gerenciador.models.Endereco;
import com.andersonhelder.gerenciador.service.EnderecoService;

@RestController
@RequestMapping("/api")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping(value="/pessoaEndereco/{id}")
	public ResponseEntity<Endereco> buscarEnderecoPorId(@PathVariable long id){
		Endereco endereco = enderecoService.buscarEnderecoPorId(id);
		return ResponseEntity.ok().body(endereco);
	}
	
	@GetMapping(value="/pessoaenderecos")
	public ResponseEntity<List<Endereco>> buscarEnderecosPessoas(){
		return ResponseEntity.ok().body(enderecoService.listarEnderecoPessoas());
	}
	
	@PostMapping(value = "/inserir/endereco")
	public Endereco salvarEndereco(@RequestBody EnderecoDTO endereco) {
		return enderecoService.salvarEndereco(endereco);
	}
}
