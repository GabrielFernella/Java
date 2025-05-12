package com.cleanArch.cleanArchPessoa.core.entities;

import com.cleanArch.cleanArchPessoa.core.enums.EnumTipoPessoa;

public record Pessoa(Long id,
                     String nome,
                     String email,
                     String cpfCnpj,
                     EnumTipoPessoa tipo) {}