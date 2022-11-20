import exceptions.*;
import java.util.Scanner;

/*  title:
 *  subtitle: Laboratorio de Modelagem (LMA)
 *  author: GM de Oliveira, GS Vilmar, PTV Giorgi
 *  date: 18/10/2022
 */

public class Pergunta
{
    private int dificuldade;
    private String pergunta = "";
    private int resposta;

    private Alternativa[] alternativas = new Alternativa[6];

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
    public Alternativa[] getAlternativas() { return alternativas.clone(); }

    public void inserirAlternativas(){
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira as alternativas da pergunta: ");

        //2 espaços do armazenador de alternativas são utilizados para "Ajuda" e "Parar"
        while(i < alternativas.length - 2){
            System.out.print((i + 1) + " - ");
            String texto = scanner.nextLine();
            alternativas[i] = new Alternativa(texto, i);
            i++;
        }
        alternativas[i] = new Alternativa("Ajuda", 5);
        alternativas[i] = new Alternativa("Parar", 6);
    }
}
