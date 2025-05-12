package com.cleanArch.cleanArchPessoa.core.usecases.Impl;

import com.cleanArch.cleanArchPessoa.core.entities.Pessoa;
import com.cleanArch.cleanArchPessoa.core.exceptions.BusinessException;
import com.cleanArch.cleanArchPessoa.core.gateways.PessoaGateway;
import com.cleanArch.cleanArchPessoa.core.usecases.CreatePessoaUseCase;

public class CreatePessoaUseCaseImpl implements CreatePessoaUseCase {

    private final PessoaGateway pessoaGateway;

    public CreatePessoaUseCaseImpl (PessoaGateway pessoaGateway){
        this.pessoaGateway = pessoaGateway;
    }

    @Override
    public Pessoa execute(Pessoa pessoa) {

        // verifica se a pessoa já existe
        Pessoa pessoaExiste = pessoaGateway.findByCpfCnpj(pessoa.cpfCnpj());

        if (pessoaExiste != null) {
            throw new BusinessException("Já existe uma pessoa com esse CPF/CNPJ");
        }

        return pessoaGateway.createPessoa(pessoa);
    }
}
