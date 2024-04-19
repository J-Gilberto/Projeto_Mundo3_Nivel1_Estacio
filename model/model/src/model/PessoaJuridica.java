package model;

import java.io.Serializable;

public class PessoaJuridica extends Pessoa implements Serializable {

    private int cnpj;

    public PessoaJuridica() {
    }

    public PessoaJuridica(int id, int cnpj, String nome) {
        super(id, nome);
        this.cnpj = cnpj;
    }

    public void exibir() {
        System.out.println("Pessoa Juridica");
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("CNPJ: " + cnpj);
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }
}
