package com.cleanArch.cleanArchPessoa.infraestructure.persistence;


import com.cleanArch.cleanArchPessoa.core.enums.EnumTipoPessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "TB_PESSOA")
public class PessoaEntity {

    @Id
    @GeneratedValue
    private Long Id;
    private String nome;
    private String email;
    private String cpfCnpj;

    @Enumerated(EnumType.STRING)
    private EnumTipoPessoa tipo;

}
