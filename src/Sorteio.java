import java.util.Random;

/*  title:
 *  subtitle: Laboratorio de Modelagem (LMA)
 *  author: GM de Oliveira, GS Vilmar, PTV Giorgi
 *  date: 18/10/2022
 */

public class Sorteio
{
    static Random rand = new Random();

    public Sorteio(){

    }

    public static int sortearAluno(int limite){
        return rand.nextInt(limite);
    }

    public static int sortearPergunta(int limite){
        return rand.nextInt(limite);
    }
}