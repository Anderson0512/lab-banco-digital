package com.lab.banco.digital.entities;

import com.lab.banco.digital.interfaces.IConta;
import lombok.Getter;

@Getter
public abstract class Conta implements IConta {
	
	private static final int DEFAULT_AGENCY = 1;
	private static int sequentialNumber = 1;

	protected int agency;
	protected int numberAccount;
	protected double balance;
	protected Cliente cliente;

	protected Conta(Cliente cliente) {
		this.agency = Conta.DEFAULT_AGENCY;
		this.numberAccount = sequentialNumber++;
		this.cliente = cliente;
	}

	@Override
	public void toWithdraw(double valor) {
		balance -= valor;
	}

	@Override
	public void deposit(double valor) {
		balance += valor;
	}

	@Override
	public void transfer(double valor, IConta destinationAccount) {
		this.toWithdraw(valor);
		destinationAccount.deposit(valor);
	}

	protected void imprimirInfosComuns() {

		String[] words = this.cliente.getNome().split("\\s");
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < words.length; i++){
			sb.append(words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase());
			sb.append(" ");
		}

		System.out.printf("Titular: %s%n", sb);
		System.out.printf("Agencia: %d%n", this.agency);
		System.out.printf("Numero: %d%n", this.numberAccount);
		System.out.printf("Saldo: R$ %.2f%n", this.balance);

//		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
//		System.out.println(String.format("Agencia: %d", this.agency));
//		System.out.println(String.format("Numero: %d", this.numberAccount));
//		System.out.println(String.format("Saldo: %.2f", this.balance));
//		log.info(String.format("Titular: %s", this.cliente.getNome()));
//		log.info("Agencia: {}", this.agency);
//		log.info("Numero: {}", this.numberAccount);
//		log.info(String.format("Saldo: %.2f", this.balance));
	}
}
