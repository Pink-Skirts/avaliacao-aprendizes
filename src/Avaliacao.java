/*  title:
 *  subtitle: Laboratorio de Modelagem (LMA)
 *  author: GM de Oliveira, GS Vilmar, PTV Giorgi
 *  date: 18/10/2022
 */

public class Avaliacao
{
    public void avaliar1(Turma turma, int indiceAlunoEscolhido){
       turma.getAprendiz(indiceAlunoEscolhido).setNota(4);
    }
    public void avaliar2(Turma turma, int indiceAlunoEscolhido){
        turma.getAprendiz(indiceAlunoEscolhido).setNota(7);
    }
    public void avaliar3(Turma turma, int indiceAlunoEscolhido){
        turma.getAprendiz(indiceAlunoEscolhido).setNota(10);
        avaliado(turma, indiceAlunoEscolhido);
    }

    public void avaliado(Turma turma, int indiceAlunoEscolhido){
        turma.getAprendiz(indiceAlunoEscolhido).setAvaliado(true);
    }
}
