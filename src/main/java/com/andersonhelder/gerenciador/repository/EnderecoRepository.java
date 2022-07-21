package com.andersonhelder.gerenciador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andersonhelder.gerenciador.models.Endereco;
import com.andersonhelder.gerenciador.models.Pessoa;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	Endereco findById(long id);
	List<Endereco> findByPessoa(Pessoa pessoa);
}
