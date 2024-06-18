package org.example.controladorBanco;

import lombok.Getter;
import lombok.Setter;

import org.example.exeptions.ContaException;
import org.example.user.Cliente;

import java.util.ArrayList;
import java.util.List;


public class Banco {
    public static final String CLIENTE_NAO_POSSUI_CONTA = "Esse cliente não possui conta";
    @Getter
    @Setter
    private String nome;
    private List<Conta> listaContas;

    public Banco(String nome) {
        listaContas = new ArrayList<>();
        this.nome = nome;
    }

    public boolean adicionarConta(Conta conta){
        return listaContas.add(conta);
    }
    public boolean adicionarConta(List<Conta> contas){
        return listaContas.addAll(contas);
    }

    public Conta buscarContaPorNomeDoClienteETipo(String nome, TipoDeConta tipoDeConta){
        return switch (tipoDeConta) {
            case CONTA_CORRENTE -> listaContas.stream().filter(
                    conta -> conta.getCliente().getNome().equalsIgnoreCase(nome) &&
                            conta instanceof ContaCorrente
            ).findFirst().orElseThrow(() -> new ContaException(CLIENTE_NAO_POSSUI_CONTA));
            case CONTA_POUPANCA -> listaContas.stream().filter(
                    conta -> conta.getCliente().getNome().equalsIgnoreCase(nome) &&
                            conta instanceof ContaPoupanca
            ).findFirst().orElseThrow(() -> new ContaException(CLIENTE_NAO_POSSUI_CONTA));
        };
    }

    public List<Cliente> listarClientesDoBanco(){
        return listaContas.stream().map(Conta::getCliente).toList();
    }

    public int contarContasPorTipo(TipoDeConta tipoDeConta){
        return switch (tipoDeConta) {
            case CONTA_CORRENTE -> listaContas.stream().filter(
                    conta -> conta instanceof ContaCorrente).toList().size();
            case CONTA_POUPANCA -> listaContas.stream().filter(
                    conta -> conta instanceof ContaPoupanca).toList().size();
        };
    }

    public boolean removerConta(Conta conta){
        return listaContas.remove(conta);
    }
}
