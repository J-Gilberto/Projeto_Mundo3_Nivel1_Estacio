package main;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.*;

public class CadastroPOO {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Incluir Pessoa Física");
            System.out.println("2 - Alterar Pessoa Física");
            System.out.println("3 - Excluir Pessoa Física");
            System.out.println("4 - Obter Pessoa Física por ID");
            System.out.println("5 - Obter Todas as Pessoas Físicas");
            System.out.println("6 - Incluir Pessoa Jurídica");
            System.out.println("7 - Alterar Pessoa Jurídica");
            System.out.println("8 - Excluir Pessoa Jurídica");
            System.out.println("9 - Obter Pessoa Jurídica por ID");
            System.out.println("10 - Obter Todas as Pessoas Jurídicas");
            System.out.println("11 - Salvar Dados (Físicas)");
            System.out.println("12 - Salvar Dados (Jurídicas)");
            System.out.println("13 - Recuperar Dados (Físicas)");
            System.out.println("14 - Recuperar Dados (Jurídicas)");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir quebra de linha

                switch (opcao) {
                    case 1: // Incluir Pessoa Física
                        incluirPessoaFisica(scanner, repoFisica);
                        break;
                    case 2: // Alterar Pessoa Física
                        alterarPessoaFisica(scanner, repoFisica);
                        break;
                    case 3: // Excluir Pessoa Física
                        excluirPessoaFisica(scanner, repoFisica);
                        break;
                    case 4: // Obter Pessoa Física por ID
                        obterPessoaFisicaPorId(scanner, repoFisica);
                        break;
                    case 5: // Obter Todas as Pessoas Físicas
                        obterTodasPessoasFisicas(repoFisica);
                        break;
                    case 6: // Incluir Pessoa Jurídica
                        incluirPessoaJuridica(scanner, repoJuridica);
                        break;
                    case 7: // Alterar Pessoa Jurídica
                        alterarPessoaJuridica(scanner, repoJuridica);
                        break;
                    case 8: // Excluir Pessoa Jurídica
                        excluirPessoaJuridica(scanner, repoJuridica);
                        break;
                    case 9: // Obter Pessoa Jurídica por ID
                        obterPessoaJuridicaPorId(scanner, repoJuridica);
                        break;
                    case 10: // Obter Todas as Pessoas Jurídicas
                        obterTodasPessoasJuridicas(repoJuridica);
                        break;
                    case 11: // Salvar Dados (Físicas)
                        salvarDadosFisicas(scanner, repoFisica);
                        break;
                    case 12: // Salvar Dados (Jurídicas)
                        salvarDadosJuridicas(scanner, repoJuridica);
                        break;
                    case 13: // Recuperar Dados (Físicas)
                        recuperarDadosFisicas(scanner, repoFisica);
                        break;
                    case 14: // Recuperar Dados (Jurídicas)
                        recuperarDadosJuridicas(scanner, repoJuridica);
                        break;
                    case 0: // Sair
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número.");
                scanner.next(); // Consumir entrada inválida
            }
        } while (opcao != 0);

        scanner.close();
    }

    // Métodos para as funcionalidades do menu (incluir, alterar, etc.)
    private static void incluirPessoaFisica(Scanner scanner, PessoaFisicaRepo repo) {
        System.out.println("\nIncluir Pessoa Física:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha

        PessoaFisica pessoaFisica = new PessoaFisica(id, nome, cpf, idade);
        repo.inserir(pessoaFisica);
        System.out.println("Pessoa Física incluída com sucesso!");
    }

    private static void alterarPessoaFisica(Scanner scanner, PessoaFisicaRepo repo) {
        System.out.println("\nAlterar Pessoa Física:");
        System.out.print("ID da pessoa física a ser alterada: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha

        PessoaFisica pessoaFisica = repo.obter(id);
        if (pessoaFisica != null) {
            System.out.print("Novo nome: ");
            pessoaFisica.setNome(scanner.nextLine());

            System.out.print("Novo CPF: ");
            pessoaFisica.setCpf(scanner.nextInt());

            System.out.print("Nova idade: ");
            pessoaFisica.setIdade(scanner.nextInt());
            scanner.nextLine(); // Consumir quebra de linha

            repo.alterar(pessoaFisica);
            System.out.println("Pessoa Física alterada com sucesso!");
        } else {
            System.out.println("Pessoa Física com ID " + id + " não encontrada.");
        }
    }

    private static void excluirPessoaFisica(Scanner scanner, PessoaFisicaRepo repo) {
        System.out.println("\nExcluir Pessoa Física:");
        System.out.print("ID da pessoa física a ser excluída: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha

        repo.excluir(id);
        System.out.println("Pessoa Física com ID " + id + " excluída com sucesso!");
    }

    private static void obterPessoaFisicaPorId(Scanner scanner, PessoaFisicaRepo repo) {
        System.out.println("\nObter Pessoa Física por ID:");
        System.out.print("ID da pessoa física: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha

        PessoaFisica pessoaFisica = repo.obter(id);
        if (pessoaFisica != null) {
            pessoaFisica.exibir();
        } else {
            System.out.println("Pessoa Física com ID " + id + " não encontrada.");
        }
    }

    private static void obterTodasPessoasFisicas(PessoaFisicaRepo repo) {
        System.out.println("\nObter Todas as Pessoas Físicas:");
        List<PessoaFisica> pessoasFisicas = repo.obterTodos();
        if (!pessoasFisicas.isEmpty()) {
            for (PessoaFisica pessoaFisica : pessoasFisicas) {
                pessoaFisica.exibir();
                System.out.println("----------------------");
            }
        } else {
            System.out.println("Não há pessoas físicas cadastradas.");
        }
    }

    private static void salvarDadosFisicas(Scanner scanner, PessoaFisicaRepo repo) throws IOException {
        System.out.println("\nSalvar Dados (Pessoas Físicas):");
        System.out.print("Nome do arquivo para salvar: ");
        String nomeArquivo = scanner.nextLine();

        repo.persistir(nomeArquivo);
    }

    private static void recuperarDadosFisicas(Scanner scanner, PessoaFisicaRepo repo)
            throws IOException, ClassNotFoundException {
        System.out.println("\nRecuperar Dados (Pessoas Físicas):");
        System.out.print("Nome do arquivo para recuperar: ");
        String nomeArquivo = scanner.nextLine();

        repo.recuperar(nomeArquivo);
        System.out.println("Dados recuperados com sucesso!");
    }

    private static void incluirPessoaJuridica(Scanner scanner, PessoaJuridicaRepo repo) {
        System.out.println("\nIncluir Pessoa Jurídica:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();

        PessoaJuridica pessoaJuridica = new PessoaJuridica(id, nome, cnpj);
        repo.inserir(pessoaJuridica);
        System.out.println("Pessoa Jurídica incluída com sucesso!");
    }

    private static void alterarPessoaJuridica(Scanner scanner, PessoaJuridicaRepo repo) {
        System.out.println("\nAlterar Pessoa Jurídica:");
        System.out.print("ID da pessoa jurídica a ser alterada: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha

        PessoaJuridica pessoaJuridica = repo.obter(id);
        if (pessoaJuridica != null) {
            System.out.print("Novo nome: ");
            pessoaJuridica.setNome(scanner.nextLine());

            System.out.print("Novo CNPJ: ");
            pessoaJuridica.setCnpj(scanner.nextInt());

            repo.alterar(pessoaJuridica);
            System.out.println("Pessoa Jurídica alterada com sucesso!");
        } else {
            System.out.println("Pessoa Jurídica com ID " + id + " não encontrada.");
        }
    }

    private static void excluirPessoaJuridica(Scanner scanner, PessoaJuridicaRepo repo) {
        System.out.println("\nExcluir Pessoa Jurídica:");
        System.out.print("ID da pessoa jurídica a ser excluída: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha

        repo.excluir(id);
        System.out.println("Pessoa Jurídica com ID " + id + " excluída com sucesso!");
    }

    private static void obterPessoaJuridicaPorId(Scanner scanner, PessoaJuridicaRepo repo) {
        System.out.println("\nObter Pessoa Jurídica por ID:");
        System.out.print("ID da pessoa jurídica: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha

        PessoaJuridica pessoaJuridica = repo.obter(id);
        if (pessoaJuridica != null) {
            pessoaJuridica.exibir();
        } else {
            System.out.println("Pessoa Jurídica com ID " + id + " não encontrada.");
        }
    }

    private static void obterTodasPessoasJuridicas(PessoaJuridicaRepo repo) {
        System.out.println("\nObter Todas as Pessoas Jurídicas:");
        List<PessoaJuridica> pessoasJuridicas = repo.obterTodos();
        if (!pessoasJuridicas.isEmpty()) {
            for (PessoaJuridica pessoaJuridica : pessoasJuridicas) {
                pessoaJuridica.exibir();
                System.out.println("----------------------");
            }
        } else {
            System.out.println("Não há pessoas jurídicas cadastradas.");
        }
    }

    private static void salvarDadosJuridicas(Scanner scanner, PessoaJuridicaRepo repo) throws IOException {
        System.out.println("\nSalvar Dados (Pessoas Jurídicas):");
        System.out.print("Nome do arquivo para salvar: ");
        String nomeArquivo = scanner.nextLine();

        repo.persistir(nomeArquivo);
    }

    private static void recuperarDadosJuridicas(Scanner scanner, PessoaJuridicaRepo repo)
            throws IOException, ClassNotFoundException {
        System.out.println("\nRecuperar Dados (Pessoas Jurídicas):");
        System.out.print("Nome do arquivo para recuperar");
    }

}
