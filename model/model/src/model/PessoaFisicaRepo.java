package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PessoaFisicaRepo implements Serializable {

    private List<PessoaFisica> listaPessoaFisica;
    private Properties prop;

    public PessoaFisicaRepo() throws IOException {
        this.listaPessoaFisica = new ArrayList<>();
        this.prop = new Properties();
        prop.load(getClass().getResourceAsStream("/resources/config.properties"));
    }

    // Métodos para CRUD (Criar, Ler, Atualizar, Deletar)
    public void inserir(PessoaFisica pessoaFisica) {
        listaPessoaFisica.add(pessoaFisica);
        System.out.println("Pessoa Física incluída com sucesso!");
    }

    public void alterar(PessoaFisica pessoaFisica) {
        int index = listaPessoaFisica.indexOf(pessoaFisica);
        if (index != -1) {
            listaPessoaFisica.set(index, pessoaFisica);
            System.out.println("Pessoa Física alterada com sucesso!");
        } else {
            System.out.println("Pessoa Física não encontrada para alteração.");
        }
    }

    public void excluir(int id) {
        listaPessoaFisica.removeIf(pessoaFisica -> pessoaFisica.getId() == id);
        System.out.println("Pessoa Física excluída com sucesso!");
    }

    public PessoaFisica obter(int id) {
        for (PessoaFisica pessoaFisica : listaPessoaFisica) {
            if (pessoaFisica.getId() == id) {
                return pessoaFisica;
            }
        }
        return null;
    }

    public List<PessoaFisica> obterTodos() {
        return listaPessoaFisica;
    }

    // Métodos para persistir e recuperar dados de arquivos
    public void persistir(String nomeArquivo) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(prop.getProperty("arquivo.fisica"));
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(listaPessoaFisica);
        }
        System.out.println("Dados salvos em " + nomeArquivo + " com sucesso!");
    }

    public PessoaFisica recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(prop.getProperty("arquivo.fisica"));
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (PessoaFisica) ois.readObject();
        }

        // System.out.println("Dados recuperados de " + nomeArquivo + " com
        // sucesso!");//
    }
}
