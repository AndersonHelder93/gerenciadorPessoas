package com.andersonhelder.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andersonhelder.gerenciador.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	Endereco findById(long id);
}
