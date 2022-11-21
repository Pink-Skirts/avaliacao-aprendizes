/*
 * title: Turma.java
 * subtitle: Classe que representa uma turma
 * authors: Guilherme Monteiro de Oliveira, Gustavo Scaglione Vilmar, Pietro Tadeu Vieira Giorgi
 * date: Tue Nov 15 16:14:09 2022
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Turma {
    private ArrayList<Aprendiz> turma; //Criando uma lista "modular" de aprendizes para compor a turma
    private int limiteTamanhoTurma;

    /**
     * Construtor da classe turma
     **/
    public Turma (){
        this.turma = new ArrayList<Aprendiz>(); //Criando uma nova turma
        preencherTurma();
    }

    /**
     * Retorna a quantidade de aprendizes na turma
     *
     * @return turma.size   Quantidade de elementos no ArrayList
     **/
    public int getTamanhoTurma (){
        return turma.size();
    }
    public int getLimiteTamanhoTurma() { return limiteTamanhoTurma; }

    /**
     * Retorna a lista da turma
     *
     * @return turma   ArrayList da Aprendizes
     **/
    public ArrayList<Aprendiz> getTurma (){
        return turma;
    }

    public void setLimiteTamanhoTurma(int limiteTamanhoTurma){ limiteTamanhoTurma = this.limiteTamanhoTurma; }

    /**
     * Preenche a turma com os aprendizes
     **/
    public void preencherTurma(){
        Scanner entrada = new Scanner(System.in);
        boolean valido;
        String nome;
        System.out.println("Insira o nome do aprendiz a ser inserido na Turma (quando estiver terminado aperte " +
                    "enter para finalizar): ");
        do {
            valido = true;
            nome = entrada.nextLine();
            if (nome.matches(".*[0-9].*")){ // Verificacao de inconsistencias no nome do aprendiz
                valido = false;
                System.out.println("Nome inserido é invalido.");
            }
            if(valido){
                if (!nome.equals("")){ //Caso o nome seja valido e nao seja nulo ele e adicionado na lista da turma
                    turma.add(new Aprendiz(nome));
                }
            }
        } while (!nome.equals("") || !valido);
        System.out.println("Tamanho da turma: " + turma.size() + " alunos"); //Mostra o tamanho da turma criada
    }

    /**
     * Mostra os aprendizes registrados na turma
     **/
    public void mostrarAprendizes (){
        if (!turma.isEmpty()){
            for(int i = 0; i < turma.size(); i++){
                System.out.println((i + 1) + " - " + "Nome: " + turma.get(i).getNome() + " --> Nota: " + turma.get(i).getNota()); //Cada elemento na lista da turma sera mostrado na tela
            }
        } else {
            System.out.println("A turma esta vazia"); //Caso a turma esteja vazia
        }
    }

    public Aprendiz getAprendiz(int index){
        return turma.get(index);
    }
}
