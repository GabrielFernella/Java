package com.cleanArch.cleanArchPessoa.infraestructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {
    PessoaEntity findByCpfCnpj(String cpfCnpj);
}
