package com.cleanArch.cleanArchPessoa.core.usecases.Impl;

import com.cleanArch.cleanArchPessoa.core.entities.Pessoa;
import com.cleanArch.cleanArchPessoa.core.gateways.PessoaGateway;
import com.cleanArch.cleanArchPessoa.core.usecases.GetAllPessoasUseCase;

import java.util.List;

public class GetAllPessoasUseCaseImpl implements GetAllPessoasUseCase {

    private final PessoaGateway pessoaGateway;

    public GetAllPessoasUseCaseImpl (PessoaGateway pessoaGateway){
        this.pessoaGateway = pessoaGateway;
    }


    @Override
    public List<Pessoa> execute() {
        return pessoaGateway.obtainAllPessoas();
    }
}
