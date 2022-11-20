/*  title:
 *  subtitle: Laboratorio de Modelagem (LMA)
 *  author: GM de Oliveira, GS Vilmar, PTV Giorgi
 *  date: 18/10/2022
 */

public class Alternativa
{
    private String textoAlternativa = " ";
    private int alternativa; //1 ate 4, ID da alternativa

    public Alternativa(String textoAlternativa, int alternativa){
        setTextoAlternativa(textoAlternativa);
        setAlternativa(alternativa);
    }

    //Setters
    private void setTextoAlternativa(String textoAlternativa){
        this.textoAlternativa = textoAlternativa;
    }
    private void setAlternativa(int alternativa){
        this.alternativa = alternativa;
    }

    //Getters
    public String getTextoAlternativa(){
        return this.textoAlternativa;
    }
    public int getAlternativa(){
        return this.alternativa;
    }
}
