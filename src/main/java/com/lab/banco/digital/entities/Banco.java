package com.lab.banco.digital.entities;

import com.lab.banco.digital.mock.MockBff;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Banco {
  private String nome;
  private List<Conta> contas;

  public void printAccounts() {

    this.contas = MockBff.getContaList();

    System.out.println("\n == Imprimindo Contas do Banco ==\n");
    for (Conta item : contas) {
      System.out.printf("    Titular: %s%n", item.getCliente().getNome());
      System.out.printf("    Agencia: %d%n", item.getAgency());
      System.out.printf("    Numero: %d%n", item.getNumberAccount());
      System.out.println("===   ||   ===   ||   ===");
    }
  }
}
