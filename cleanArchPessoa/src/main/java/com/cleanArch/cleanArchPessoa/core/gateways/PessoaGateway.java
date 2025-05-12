package com.cleanArch.cleanArchPessoa.core.gateways;

import com.cleanArch.cleanArchPessoa.core.entities.Pessoa;

import java.util.List;

public interface PessoaGateway {

    Pessoa createPessoa(Pessoa pessoa);

    Pessoa findByCpfCnpj(String cpfCnpj);

    List<Pessoa> obtainAllPessoas();
}
