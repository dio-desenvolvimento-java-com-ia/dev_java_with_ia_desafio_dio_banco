package org.example.interfaces;

import org.example.controladorBanco.Conta;

public interface OperacoesContasI {
    void sacar(double value);

    void depositar(double value);

    void transferir(double value, Conta contaDestino);

    void imprimirExtrato();

}
