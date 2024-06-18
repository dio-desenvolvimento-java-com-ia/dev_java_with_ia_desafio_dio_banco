package org.example.controladorBanco;

import lombok.Getter;
import org.example.user.Cliente;

@Getter
public class ContaPoupanca extends Conta  {


    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
  public void imprimirExtrato() {
      System.out.println("=== Extrato conta poupança ===");
      super.imprimirExtrato();
  }
 }
