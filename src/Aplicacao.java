import java.util.Scanner;

/*
 * title: Aplicacao.java
 * subtitle: Classe main da aplicao - Avaliacao de aprendizes
 * authors: Guilherme Monteiro de Oliveira, Gustavo Scaglione Vilmar, Pietro Tadeu Vieira Giorgi
 * date: Tue Nov 15 15:27:52 2022
 */

public class Aplicacao //Metodo main da aplicacao
{
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu(){

        Turma turma = new Turma();

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
                    turma.preencherTurma(); //todo
                    break;
                case 3:
                    turma.mostrarAprendizes(); //todo
                    break;
                case 4:
                    config(); //Configuracoes das rodadas + outros
                    break;
                default:
                    saida = true;
                    break;
            }
        }
    }

    public static void config(){ //todo
        boolean saida = false;
        while(!saida){
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
                    saida = true;
                    break;
            }
        }
    }
}

//Cenario 1: Aprendizes acertam as tres perguntas da rodada
//Cenario 2: Aprendizes erram a resposta
//Cenario 3: Ocorre pedido de ajuda
//Cenario 4: Ocorre um pedido para encerramento da rodada
