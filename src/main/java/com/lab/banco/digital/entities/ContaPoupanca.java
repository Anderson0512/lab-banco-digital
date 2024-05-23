package com.lab.banco.digital.entities;


public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void printStatement() {
		System.out.println("\n=== Extrato Conta Poupança ===");
		super.imprimirInfosComuns();
	}
}
