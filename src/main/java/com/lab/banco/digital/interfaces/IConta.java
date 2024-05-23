package com.lab.banco.digital.interfaces;

public interface IConta {
	
	void toWithdraw(double valor);//sacar
	
	void deposit(double valor);//depositar
	
	void transfer(double valor, IConta destinationAccount); //transferir
	
	void printStatement(); //imprimeir
}
