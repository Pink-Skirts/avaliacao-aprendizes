/*
 * title: Turma.java
 * subtitle: Classe que representa uma turma
 * authors: Guilherme Monteiro de Oliveira, Gustavo Scaglione Vilmar, Pietro Tadeu Vieira Giorgi
 * date: Tue Nov 15 16:14:09 2022
 */

import java.util.ArrayList;

public class Turma {
    private ArrayList<Aprendiz> turma; //Criando uma lista "modular" de aprendizes para compor a turma

    /**
     * Construtor da classe turma
     **/
    public Turma (){
        this.turma = new ArrayList<Aprendiz>(); //Criando uma nova turma
    }

    /**
     * Retorna a quantidade de aprendizes na turma
     *
     * @return turma.size   Quantidade de elementos no ArrayList
     **/
    public int getTamanhoTurma (){
        return turma.size();
    }

    /**
     * Mostra os aprendizes registrados na turma
     **/
    public void mostrarAprendizes (){
        if (!turma.isEmpty()){
            for(int i = 0; i < turma.size(); i++){
                System.out.println(i + " - " + turma.get(i)); //Cada elemento na lista da turma sera mostrado na tela
            }
        } else {
            System.out.println("A turma esta vazia"); //Caso a turma esteja vazia
        }
    }
}
