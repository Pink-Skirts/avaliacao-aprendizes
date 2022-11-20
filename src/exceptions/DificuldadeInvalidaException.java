package exceptions;

/*  title:
 *  subtitle: Laboratorio de Modelagem (LMA)
 *  author: GM de Oliveira, GS Vilmar, PTV Giorgi
 *  date: 18/10/2022
 */

public class DificuldadeInvalidaException extends Exception
{
    public DificuldadeInvalidaException() {}

    public DificuldadeInvalidaException(String mensagem){
        super(mensagem);
    }
}
