/*  title: Menu.java
 *  subtitle: Laboratorio de Modelagem (LMA)
 *  author: GM de Oliveira, GS Vilmar, PTV Giorgi
 *  date: 18/10/2022
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private ArrayList<Turma> turmas = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public Menu() {
        iniciarMenu();
    }

    public void iniciarMenu() {

        boolean saida = false;
        boolean isTurmasVazia = true;
        String input;
        int i, j;

        Aplicacao.limparTela();

        while (!saida) {
            System.out.print(
                    "____________________________________________________\n" +
                            "Seja bem-vindo ao programa de perguntas e respostas!\n" +
                            "Escolha uma opcao:\n" +
                            "1 - Iniciar rodada\n" +
                            "2 - Criar turma de aprendizes\n" +
                            "3 - Mostrar aprendizes\n" +
                            "4 - Configuracoes\n" +
                            "5 - Sair\n"
            );
            i = scanner.nextInt();

            switch (i) {
                case 1:
                    if (turmas.size() != 0) {
                        System.out.println("Escolha uma turma: ");
                        mostrarTurmas();
                        i = scanner.nextInt();
                        new Rodada(turmas.get(i - 1));
                    } else {
                        System.out.println("\n\nNao ha nenhuma turma suficiente para comecar uma rodada!");
                    }
                    break;
                case 2:
                    turmas.add(new Turma());
                    isTurmasVazia = false;
                    break;
                case 3:
                    if (turmas.size() != 0) {
                        System.out.println("\n\nSelecione a turma: ");
                        mostrarTurmas();
                        int escolha = scanner.nextInt();

                        //Impedir o usuario de escolher uma turma nao-existente
                        if (escolha <= turmas.size() && escolha > 0) {
                            turmas.get(escolha - 1).mostrarAprendizes();
                        } else {
                            System.out.println("Entrada incorreta!");
                        }
                    } else {
                        System.out.println("\n\nNao ha nenhuma turma existente!");
                    }
                    break;
                case 4:
                    boolean saidaOpcoes = false; //Configuracoes das turmas
                    while (!saidaOpcoes) {
                        System.out.println(
                                "Menu de Opcoes:\n" +
                                        "1 - Remover aluno de uma turma\n" +
                                        "2 - Adicionar aluno a uma turma\n" +
                                        "3 - Mudar o nome de um aluno\n" +
                                        "4 - Excluir uma turma\n" +
                                        "5 - Sair\n"
                        );

                        int x = scanner.nextInt();
                        switch (x) {
                            case 1:
                                if (!isTurmasVazia) {
                                    Aplicacao.limparTela();
                                    System.out.println("De qual turma deseja remover?:");
                                    mostrarTurmas();
                                    i = scanner.nextInt();
                                    System.out.println("Qual aluno voce deseja remover?:");
                                    mostraAlunosTurma(turmas.get(i - 1));
                                    j = scanner.nextInt();
                                    turmas.get(i - 1).removerAprendiz(j - 1);
                                } else {
                                    System.out.println("Nenhuma turma foi criada!");
                                }
                                break;
                            case 2:
                                if (!isTurmasVazia) {
                                    Aplicacao.limparTela();
                                    System.out.println("Em qual turma deseja adicionar?:");
                                    mostrarTurmas();
                                    i = scanner.nextInt();
                                    System.out.println("Insira o nome do aluno: ");
                                    input = scanner.next();
                                    turmas.get(i - 1).adicionarAprendiz(input);
                                    System.out.println("Aluno inserido!");
                                } else {
                                    System.out.println("Nenhuma turma foi criada!");
                                }
                                break;
                            case 3:
                                if (!isTurmasVazia) {
                                    Aplicacao.limparTela();
                                    System.out.println("De qual turma deseja modificar?:");
                                    mostrarTurmas();
                                    i = scanner.nextInt();
                                    System.out.println("Qual aluno voce deseja modificar?:");
                                    mostraAlunosTurma(turmas.get(i - 1));
                                    j = scanner.nextInt();
                                    System.out.println("Insira o novo nome do aluno: ");
                                    input = scanner.next();
                                    turmas.get(i - 1).getAprendiz(j - 1).setNome(input);
                                    System.out.println("Aluno modificado!");
                                } else {
                                    System.out.println("Nenhuma turma foi criada!");
                                }
                                break;
                            case 4:
                                if (!isTurmasVazia) {
                                    Aplicacao.limparTela();
                                    System.out.println("Qual turma deseja remover?:");
                                    mostrarTurmas();
                                    i = scanner.nextInt();
                                    turmas.remove(i - 1);
                                    System.out.println("Turma removida!\n");
                                } else {
                                    System.out.println("Nenhuma turma foi criada!");
                                }
                                break;
                            default:
                                saidaOpcoes = true;
                                break;
                        }
                    }
                    break;
                default:
                    saida = true;
                    break;
            }
        }
    }

    private void mostrarTurmas() {
        if (turmas.size() != 0) {
            for (int x = 0; x < turmas.size(); x++) {
                System.out.println("Turma " + (x + 1));
            }
        }
    }

    private void mostraAlunosTurma(Turma turma) {
        for (int x = 0; x < turma.getTamanhoTurma(); x++) {
            System.out.println("Aluno " + (x + 1) + " - " + turma.getAprendiz(x).getNome());
        }
    }
}
