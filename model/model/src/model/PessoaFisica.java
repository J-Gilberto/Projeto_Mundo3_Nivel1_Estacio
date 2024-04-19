package model;

import java.io.Serializable;

public class PessoaFisica extends Pessoa implements Serializable {

    private int cpf;
    private int idade;

    public PessoaFisica() {
    }

    public PessoaFisica(int id, int idade, int cpf, String nome) {
        super(id, nome);
        this.cpf = cpf;
        this.idade = idade;
    }

    public void exibir() {
        System.out.println("Pessoa Fisica:");
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("CPF " + cpf);
        System.out.println("Idade: " + idade);
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}
