package com.lab.banco.digital;

import com.lab.banco.digital.service.ClientService;

public class Main {
  public static void main(String[] args) {

    ClientService clientService = new ClientService();
    clientService.getService();
  }
}