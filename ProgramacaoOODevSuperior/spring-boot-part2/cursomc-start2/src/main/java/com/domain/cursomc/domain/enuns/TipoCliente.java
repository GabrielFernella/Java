package com.domain.cursomc.domain.enuns;

public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa Fisica"), PESSOAJURIDICA(2, "Pessoa Juridica");

	private int cod;
	private String descricao;

	// Construtor do tipo enumerado é private
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	// fazer apenas o método get
	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	// Operação estática que funcione mesmo que não instancie os objetos
	public static TipoCliente toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		// For que percorre todos os calores possíveis da minha classe (dois casos)
		for (TipoCliente x : TipoCliente.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}
