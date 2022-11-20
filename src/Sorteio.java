import java.util.Random;

/*  title:
 *  subtitle: Laboratorio de Modelagem (LMA)
 *  author: GM de Oliveira, GS Vilmar, PTV Giorgi
 *  date: 18/10/2022
 */

public class Sorteio
{
    public Sorteio(){

    }

    public static int sortearAluno(int limite){
        Random rand = new Random();
        return rand.nextInt(limite - 1);
    }

    public static int sortearPergunta(){
        int limitePergunta = 3;
        Random rand = new Random();
        return rand.nextInt(limitePergunta - 1);
    }
}