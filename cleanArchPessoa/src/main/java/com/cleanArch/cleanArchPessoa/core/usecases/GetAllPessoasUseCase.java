package com.cleanArch.cleanArchPessoa.core.usecases;

import com.cleanArch.cleanArchPessoa.core.entities.Pessoa;

import java.util.List;

public interface GetAllPessoasUseCase {
    public List<Pessoa> execute();
}
