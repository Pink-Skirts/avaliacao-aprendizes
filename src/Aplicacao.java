/*
 * title: Aplicacao.java
 * subtitle: Classe main da aplicao - Avaliacao de aprendizes
 * authors: Guilherme Monteiro de Oliveira, Gustavo Scaglione Vilmar, Pietro Tadeu Vieira Giorgi
 * date: Tue Nov 15 15:27:52 2022
 */

public class Aplicacao { //Metodo main da aplicacao
    public static void main(String[] args) {
        new Menu();
    }

    public static void limparTela(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}

//Cenario 1: Aprendizes acertam as tres perguntas da rodada
//Cenario 2: Aprendizes erram a resposta
//Cenario 3: Ocorre pedido de ajuda
//Cenario 4: Ocorre um pedido para encerramento da rodada
