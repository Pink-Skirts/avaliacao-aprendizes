/*  title:
 *  subtitle: Laboratorio de Modelagem (LMA)
 *  author: GM de Oliveira, GS Vilmar, PTV Giorgi
 *  date: 18/10/2022
 */

import exceptions.*;
import java.util.ArrayList;

public class Pergunta
{
    private int dificuldade;
    private String pergunta = "";
    private int resposta;

    private ArrayList<Alternativa> alternativas = new ArrayList<>();

    public Pergunta(int dificuldade, String pergunta, int resposta){
        try {
            setDificuldade(dificuldade);
            setPergunta(pergunta);
            setResposta(resposta);
        } catch(DificuldadeInvalidaException | RespostaInvalidaException e){
            e.printStackTrace();
        }
    }

    //Setters
    private void setDificuldade(int dificuldade) throws DificuldadeInvalidaException{
        /* Intervalo de 1 <= x <= 3, sendo:
         * 1 = Facil;
         * 2 = Media;
         * 3 = Dificil.
         */
        if(dificuldade > 0 && dificuldade < 4){
            this.dificuldade = dificuldade;
        } else {
            throw new DificuldadeInvalidaException("Dificuldade invalida!");
        }
    }
    public void setPergunta(String pergunta){
        this.pergunta = pergunta;
    }
    public void setResposta(int resposta) throws RespostaInvalidaException{
        if(resposta > 0 && resposta < 5){ //Intervalo de 1 <= x <= 4
            this.resposta = resposta;
        } else {
            throw new RespostaInvalidaException("ID da resposta invalido!");
        }
    }

    //Getters
    public int getDificuldade(){
        return this.dificuldade;
    }
    public String getPergunta(){
        return this.pergunta;
    }
    public int getResposta(){
        return this.resposta;
    }
    public ArrayList<Alternativa> getAlternativas() { return alternativas; }

    public void inserirAlternativas(String alt1, String alt2, String alt3){
        //2 espaços do armazenador de alternativas são utilizados para "Ajuda" e "Parar"
        alternativas.add(new Alternativa(alt1, 1));
        alternativas.add(new Alternativa(alt2, 2));
        alternativas.add(new Alternativa(alt3, 3));
        alternativas.add(new Alternativa("Ajuda", 4));
        alternativas.add(new Alternativa("Parar", 5));
    }

    public void mostrarAlternativas(){
        for (int i = 0; i < 5; i++){
            System.out.println((i + 1) + " - " + alternativas.get(i).getTextoAlternativa());
        }
    }
}
