package org.example.controladorBanco;


import lombok.Getter;

import org.example.interfaces.OperacoesContasI;
import org.example.user.Cliente;

public abstract class Conta implements OperacoesContasI {
    private static int SEQUENCIAL = 0;
    private  static  final int AGENCIA_PADRAO = 1;
    protected Integer agencia;
    protected Integer numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {

        this.cliente = cliente;
        this.agencia = AGENCIA_PADRAO;
        this.numero = ++SEQUENCIAL;
    }

    @Override
    public void sacar(double value) {
        if (value<=saldo)
            saldo -= value;

    }

    @Override
    public void depositar(double value) {
        saldo+=value;

    }

    @Override
    public void transferir(double value, Conta contaDestino) {
        this.sacar(value);
        contaDestino.depositar(value);
    }

    @Override
    public void imprimirExtrato() {
        System.out.printf("Titular: %s\n", cliente.getNome());
        System.out.printf("Agencia: %d\n", agencia);
        System.out.printf("Número: %d\n", numero);
        System.out.printf("Saldo: %.2f\n", saldo);
    }

    protected Cliente getCliente() {
        return cliente;
    }
}
