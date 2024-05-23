package com.lab.banco.digital.entities;

public class ContaCorrente extends Conta {

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void printStatement() {
		System.out.println("\n=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns();
	}
}
