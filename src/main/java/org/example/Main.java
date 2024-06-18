package org.example;

import org.example.controladorBanco.*;
import org.example.user.Cliente;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente("Renan", "renan@gmail.com", "(83) 99999-9999");
        Cliente cliente2 = new Cliente("Renata", "renata@gmail.com", "(83) 99999-9999");

        Conta cc = new ContaCorrente(cliente);
        Conta cp = new ContaPoupanca(cliente2);

        cc.depositar(100);
        cc.transferir(100, cp);

        cc.imprimirExtrato();
        cp.imprimirExtrato();

        Banco banco = new Banco("Bradesco");
        banco.adicionarConta(cc);
        banco.adicionarConta(cp);

        System.out.println(banco.listarClientesDoBanco());
        banco.buscarContaPorNomeDoClienteETipo("renan", TipoDeConta.CONTA_CORRENTE).imprimirExtrato();
        System.out.println(banco.contarContasPorTipo(TipoDeConta.CONTA_CORRENTE));
        banco.removerConta(cc);
        System.out.println(banco.buscarContaPorNomeDoClienteETipo("renan", TipoDeConta.CONTA_CORRENTE));



    }
}