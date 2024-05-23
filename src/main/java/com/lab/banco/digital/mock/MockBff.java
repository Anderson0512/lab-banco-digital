package com.lab.banco.digital.mock;

import com.lab.banco.digital.entities.Banco;
import com.lab.banco.digital.entities.Cliente;
import com.lab.banco.digital.entities.Conta;
import com.lab.banco.digital.entities.ContaCorrente;

import java.util.ArrayList;
import java.util.List;

public class MockBff {

  public static Banco bancoCl() {

    List<Conta> contas = getContaList();
    Banco banco = new Banco("Santander", contas);
    return banco;
  }

  public static List<Conta> getContaList() {
    List<Conta> contas = new ArrayList<>();

    for (int i = 1; i <= 15; i ++) {
      Cliente cliente = new Cliente();
      cliente.setNome("Cliente Banco " + i);
      Conta conta = new ContaCorrente(cliente);
      contas.add(conta);
    }
    return contas;
  }
}
