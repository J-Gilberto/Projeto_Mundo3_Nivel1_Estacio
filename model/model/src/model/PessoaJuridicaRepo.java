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

public class PessoaJuridicaRepo implements Serializable {

    private List<PessoaJuridica> listaPessoaJuridica;
    private Properties prop;

    public PessoaJuridicaRepo() throws IOException {
        this.listaPessoaJuridica = new ArrayList<>();
        this.prop = new Properties();
        prop.load(getClass().getResourceAsStream("/resources/config.properties"));
    }

    public void inserir(PessoaJuridica pessoaJuridica) {
        listaPessoaJuridica.add(pessoaJuridica);
    }

    public void alterar(PessoaJuridica pessoaJuridica) {
        int index = listaPessoaJuridica.indexOf(pessoaJuridica);
        if (index != -1) {
            listaPessoaJuridica.set(index, pessoaJuridica);
        }
    }

    public void excluir(int id) {
        listaPessoaJuridica.removeIf(pessoaJuridica -> pessoaJuridica.getId() == id);
    }

    public PessoaJuridica obter(int id) {
        for (PessoaJuridica pessoaJuridica : listaPessoaJuridica) {
            if (pessoaJuridica.getId() == id) {
                return pessoaJuridica;
            }
        }
        return null;
    }

    public List<PessoaJuridica> obterTodos() {
        return listaPessoaJuridica;
    }

    public void persistir(String nomeArquivo) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(prop.getProperty("arquivo.juridica"));
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(listaPessoaJuridica);
        }
    }

    public PessoaJuridica recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(prop.getProperty("arquivo.juridica"));
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (PessoaJuridica) ois.readObject();
        }
    }
}
