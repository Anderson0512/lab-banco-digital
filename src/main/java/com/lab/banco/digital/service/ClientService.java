package com.lab.banco.digital.service;

import com.lab.banco.digital.entities.Banco;
import com.lab.banco.digital.entities.Cliente;
import com.lab.banco.digital.entities.ContaCorrente;
import com.lab.banco.digital.entities.ContaPoupanca;
import com.lab.banco.digital.mock.MockBff;

import java.util.Locale;
import java.util.Scanner;

public class ClientService {
  public void getService() {

    Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    double valorTransf = 0.0;

    System.out.println("Digite o nome do Cliente");
    String cli = scanner.nextLine();

    System.out.println("Digite o valor do depósito:");
    double deposito = scanner.nextDouble();
    scanner.nextLine();

    System.out.println("Deseja realizar alguma transferência para Poupança? ('S' ou 'N')");

    String transf = scanner.nextLine();

    if ("s".equalsIgnoreCase(transf)) {

      System.out.println("Digite o valor a transferir");
      valorTransf = scanner.nextDouble();
      scanner.nextLine();
    }
    Cliente cliente = new Cliente(cli);
    ContaCorrente contaCorrente = new ContaCorrente(cliente);
    ContaPoupanca contaPoupanca = new ContaPoupanca(cliente);

    contaCorrente.deposit(deposito);
    contaCorrente.transfer(valorTransf, contaPoupanca);

    if ("n".equalsIgnoreCase(transf)) {
      System.out.println("Não houve depósito/transferência para conta Poupança, deseja imprimir extrato da Conta Poupança? ('S' ou 'N')");

      String print = scanner.nextLine();
      if ("s".equalsIgnoreCase(print)) {
        contaCorrente.printStatement();
        contaPoupanca.printStatement();
      } else {
        contaCorrente.printStatement();
      }
    } else {
      contaCorrente.printStatement();
      contaPoupanca.printStatement();
    }

    System.out.println("\nPara averiguação, deseja visualizar a lista de contas dos clientes? ('S' ou 'N')");
    String printAccounts = scanner.nextLine();
    if ("s".equalsIgnoreCase(printAccounts)) {
      Banco banco = new Banco();
      banco.printAccounts();
    } else {
      System.out.println("Tudo bem, nada será impresso, obrigado por utilizar os serviços!");
    }
  }
}
