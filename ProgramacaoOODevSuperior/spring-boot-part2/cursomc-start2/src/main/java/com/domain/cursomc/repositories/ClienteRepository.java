package com.domain.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.domain.cursomc.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	@Transactional(readOnly = true)// não necessita ser envolvida como uma transação de banco de dados
	Cliente findByEmail(String email); // só de ecrever o spring boot entende o que vc quer filtrar
}
