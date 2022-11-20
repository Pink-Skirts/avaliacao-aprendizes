import java.util.Scanner;

/*  title:
 *  subtitle: Laboratorio de Modelagem (LMA)
 *  author: GM de Oliveira, GS Vilmar, PTV Giorgi
 *  date: 18/10/2022
 */

public class Rodada
{
    private int contRodada;
    private int escolhaAluno;
    private Scanner scanner = new Scanner(System.in);
    private Turma turma = new Turma();
    //private Aprendiz[] aprendizes = turma.getTurma();
    private Pergunta[] perguntas = new Pergunta[3];

    public Rodada(){
        setContRodada(0);
        iniciarRodada();
    }

    public void iniciarRodada(){
        boolean saida = false;
        int x;
        while(!saida) {
            System.out.println("Escolha uma opcao: \n" +
                    "1 - Comecar (Sortear um aprendiz)\n" +
                    "2 - Configurar perguntas\n" +
                    "3 - Sair");
            x = scanner.nextInt();
            switch (x) {
                case 1:
                    if (!isPerguntasVazia() ) { //&& !isAprendizesVazia()
                        System.out.println("Sorteando aluno...");
                        //System.out.println("Aluno escolhido: " + aprendizes[Sorteio.sortearAluno()].getNome());
                        System.out.println("Sorteando pergunta...");
                        System.out.println("Pergunta sorteada: " + perguntas[Sorteio.sortearPergunta()].getPergunta());
                    } else {
                        System.out.println("Configuracoes insuficientes!");
                    }
                    break;
                case 2:
                    boolean saidaPerguntas = false;
                    while(!saidaPerguntas) {
                        System.out.println("Menu de perguntas: \n" +
                                "1 - Inserir/Sobrescrever o texto de uma pergunta\n" +
                                "2 - Alterar alternativa(s) de uma pergunta\n" +
                                "3 - Sair\n");
                        x = scanner.nextInt();
                        switch (x) {
                            case 1:
                                boolean saidaConfig = false;
                                while(!saidaConfig) {
                                    System.out.println("Modificar pergunta de numero 1, 2, ou 3?: \n" +
                                            "(Insira 4 para cancelar)\n");
                                    x = scanner.nextInt();
                                    String input;
                                    switch (x) {
                                        case 1:
                                            System.out.println("Insira o texto da pergunta: ");
                                            input = scanner.next();
                                            perguntas[1].setPergunta(input);
                                            break;
                                        case 2:
                                            System.out.println("Insira o texto da pergunta: ");
                                            input = scanner.next();
                                            perguntas[2].setPergunta(input);
                                            break;
                                        case 3:
                                            System.out.println("Insira o texto da pergunta: ");
                                            input = scanner.next();
                                            perguntas[3].setPergunta(input);
                                            break;
                                        default:
                                            saidaConfig = true;
                                    }
                                }
                                break;
                            case 2:
                                //todo
                                break;
                            default:
                                saidaPerguntas = true;
                        }
                    }
                    break;
                default:
                    saida = true;
            }
        }
    }

    private boolean verificarAlunosRodada(){
        return true; //todo
    }

    private boolean isPerguntasVazia(){ //As 3 perguntas precisam ser preenchidas.
        boolean vazia = false;
        for(int i = 0; i < perguntas.length; i++){
            if(perguntas[i] == null){
                vazia = true;
            }
        }
        return vazia;
    }
/*
    private boolean isAprendizesVazia(){
        boolean vazia = false;
        for(int i = 0; i < aprendizes.length; i++){
            //if(aprendizes[i] == null){
                vazia = true;
            }
        }
        return vazia;
    }

 */

    //Setters
    private void setContRodada(int contRodada){
        this.contRodada = contRodada;
    }
    private void setEscolhaAluno(int escolhaAluno) { this.escolhaAluno = escolhaAluno; }

    //Getters
    public int getContRodada(){
        return this.contRodada;
    }
    public int getEscolhaAluno() { return this.escolhaAluno; }

}
