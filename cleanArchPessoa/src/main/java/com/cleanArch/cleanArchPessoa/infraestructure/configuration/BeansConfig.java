package com.cleanArch.cleanArchPessoa.infraestructure.configuration;

import com.cleanArch.cleanArchPessoa.core.gateways.PessoaGateway;
import com.cleanArch.cleanArchPessoa.core.usecases.CreatePessoaUseCase;
import com.cleanArch.cleanArchPessoa.core.usecases.GetAllPessoasUseCase;
import com.cleanArch.cleanArchPessoa.core.usecases.Impl.CreatePessoaUseCaseImpl;
import com.cleanArch.cleanArchPessoa.core.usecases.Impl.GetAllPessoasUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public CreatePessoaUseCase createPessoaUseCase(PessoaGateway pessoaGateway){
        return new CreatePessoaUseCaseImpl(pessoaGateway);
    }

    @Bean
    public GetAllPessoasUseCase getAllpessoasUseCase(PessoaGateway pessoaGateway){
        return new GetAllPessoasUseCaseImpl(pessoaGateway);
    }
}
