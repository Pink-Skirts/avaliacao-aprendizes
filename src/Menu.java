/*  title:
 *  subtitle: Laboratorio de Modelagem (LMA)
 *  author: GM de Oliveira, GS Vilmar, PTV Giorgi
 *  date: 18/10/2022
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private ArrayList<Turma> turmas = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public Menu(){
        iniciarMenu();
    }

    public void iniciarMenu(){

        boolean saida = false;

        while(!saida) {
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
            int i = scanner.nextInt();

            switch (i) {
                case 1:
                    new Rodada();
                    break;
                case 2:
                    turmas.add(new Turma());
                    break;
                case 3:
                    if(turmas.size() != 0) {
                        System.out.println("Selecione a turma: ");
                        for(int x = 0; x < turmas.size(); x++) {
                            System.out.println("Turma " + (x + 1));
                        }
                        int escolha = scanner.nextInt();

                        //Impedir o usuario de escolher uma turma nao-existente
                        if(escolha <= turmas.size() && escolha > 0) {
                            turmas.get(escolha - 1).mostrarAprendizes();
                        } else {
                            System.out.println("Entrada incorreta!");
                        }
                    } else {
                        System.out.println("Nao ha nenhuma turma existente!");
                    }



                    break;
                case 4:
                    boolean saidaOpcoes = false; //Configuracoes das rodadas + outros
                    while(!saidaOpcoes){
                        System.out.println(
                                "Menu de Opcoes:\n" +
                                        "1 - Alterar numero maximo de aprendizes em uma turma\n" +
                                        "2 - \n" +
                                        "3 - \n" +
                                        "4 - Sair\n"
                        );

                        int x = scanner.nextInt();
                        switch (x){
                            case 1:
                                //turma.set
                                break;
                            case 2:

                                break;
                            case 3:

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
}