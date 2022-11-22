/*  title: Parada.java
 *  subtitle: Laboratorio de Modelagem (LMA)
 *  author: GM de Oliveira, GS Vilmar, PTV Giorgi
 *  date: 18/10/2022
 */

public class Parada {

    Turma turma;
    int indiceAprendiz;
    int rodada;

    public Parada(Turma turma, int indiceAprendiz, int rodada){
        this.turma = turma;
        this.indiceAprendiz = indiceAprendiz;
        this.rodada = rodada;
    }

    public boolean pararRodada (){
        return true;
    }

    public void contabilizarPontos (){
        if(rodada == 0) {
            turma.getAprendiz(indiceAprendiz).setNota(0);
        } else if (rodada == 1) {
            turma.getAprendiz(indiceAprendiz).setNota(4);
        } else if (rodada == 2) {
            turma.getAprendiz(indiceAprendiz).setNota(7);
        }
    }
}
