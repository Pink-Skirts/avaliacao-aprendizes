package exceptions;

/*  title:
 *  subtitle: Laboratorio de Modelagem (LMA)
 *  author: GM de Oliveira, GS Vilmar, PTV Giorgi
 *  date: 18/10/2022
 */

public class RespostaInvalidaException extends Exception
{
    public RespostaInvalidaException() {}

    public RespostaInvalidaException(String mensagem){
        super(mensagem);
    }
}
