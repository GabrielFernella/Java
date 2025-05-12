package com.cleanArch.cleanArchPessoa.core.usecases;

import com.cleanArch.cleanArchPessoa.core.entities.Pessoa;

public interface CreatePessoaUseCase {

    public Pessoa execute(Pessoa pessoa);
}
