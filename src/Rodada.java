/*  title: Rodada.java
 *  subtitle: Laboratorio de Modelagem (LMA)
 *  authors: Guilherme Monteiro de Oliveira, Gustavo Scaglione Vilmar, Pietro Tadeu Vieira Giorgi
 *  date: Sun Nov 20 15:26:26 2022:
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Rodada {
    private int contRodada;
    private int escolhaAluno;
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Pergunta> perguntasFacil = new ArrayList<>(); //Lista de perguntas
    private ArrayList<Pergunta> perguntasMedia = new ArrayList<>();
    private ArrayList<Pergunta> perguntasDificil = new ArrayList<>();

    /**
     * Construtor da classe
     **/
    public Rodada(Turma turma) {
        setContRodada(0);
        iniciarRodada(turma);
    }

    public void iniciarRodada(Turma turma) {

        boolean saida = false;
        int x;

        addPerguntas();

        while (!saida) {
            System.out.println("Escolha uma opcao: \n" +
                    "1 - Comecar (Sortear um aprendiz e pergunta)\n" +
                    "2 - Configurar perguntas\n" +
                    "3 - Sair");
            x = scanner.nextInt();

            setContRodada(0);
            switch (x) {
                case 1:
                        if (!isPerguntasVazia() && !verificarAlunosRodada(turma)) {
                            int indiceAlunoEscolhido;
                            do {
                                indiceAlunoEscolhido = Sorteio.sortearAluno(turma.getTamanhoTurma());
                            } while(turma.getAprendiz(indiceAlunoEscolhido).getAvaliado());

                            System.out.println("Aluno escolhido: " + turma.getAprendiz(indiceAlunoEscolhido).getNome());

                            boolean parar = false;
                            Pergunta perguntaAux;
                            int indicePerguntaEscolhida;

                            while (!parar && getContRodada() < 3) {
                                if(getContRodada() == 0) {
                                    indicePerguntaEscolhida = Sorteio.sortearPergunta(perguntasFacil.size());
                                    perguntaAux = perguntasFacil.get(indicePerguntaEscolhida);
                                } else if (getContRodada() == 1) {
                                    indicePerguntaEscolhida = Sorteio.sortearPergunta(perguntasMedia.size());
                                    perguntaAux = perguntasMedia.get(indicePerguntaEscolhida);
                                } else {
                                    indicePerguntaEscolhida = Sorteio.sortearPergunta(perguntasDificil.size());
                                    perguntaAux = perguntasDificil.get(indicePerguntaEscolhida);
                                }
                                System.out.println("Pergunta sorteada: " + perguntaAux.getPergunta());

                                System.out.println("Escolha uma alternativa: ");
                                perguntaAux.mostrarAlternativas();

                                x = scanner.nextInt();
                                if (x == perguntaAux.getResposta()) {
                                    System.out.println("Voce acertou!");
                                    if (getContRodada() == 0) {
                                        turma.getAprendiz(indiceAlunoEscolhido).setNota(4);
                                    } else if (getContRodada() == 1 && turma.getAprendiz(indiceAlunoEscolhido).getNota()
                                            == 4) {
                                        turma.getAprendiz(indiceAlunoEscolhido).setNota(7);
                                    } else if (getContRodada() == 2 && turma.getAprendiz(indiceAlunoEscolhido).getNota()
                                            == 7) {
                                        turma.getAprendiz(indiceAlunoEscolhido).setNota(10);
                                        turma.getAprendiz(indiceAlunoEscolhido).setAvaliado(true);
                                    }
                                    setContRodada(getContRodada() + 1);
                                } else if (x == 4) {
                                    //new Ajuda(turma.getTamanhoTurma());
                                    setContRodada(getContRodada() + 1);
                                } else if (x == 5) {
                                    new Parada();
                                    parar = true;
                                    turma.getAprendiz(indiceAlunoEscolhido).setAvaliado(true);
                                } else {
                                    turma.getAprendiz(indiceAlunoEscolhido).setAvaliado(true);
                                    System.out.println("Resposta incorreta!");
                                    parar = true;
                                }
                            }
                        } else {
                            System.out.println("Configuracoes insuficientes!");
                        }
                    break;
                case 2:
                    boolean saidaPerguntas = false;
                    while (!saidaPerguntas) {
                        System.out.println("Menu de perguntas: \n" +
                                "1 - Sobrescrever o texto de uma pergunta\n" +
                                "2 - Alterar alternativa(s) de uma pergunta\n" +
                                "3 - Sair\n");
                        x = scanner.nextInt();
                        switch (x) {
                            case 1:
                                boolean saidaConfig = false;
                                while (!saidaConfig) {
                                    System.out.println("Modificar pergunta de numero 1, 2, ou 3?: \n" +
                                            "(Insira 4 para cancelar)\n");
                                    x = scanner.nextInt();
                                    String input;
                                    switch (x) {
                                        case 1:
                                            System.out.println("Insira o texto da pergunta: ");
                                            input = scanner.next();
                                            //perguntas.get(0).setPergunta(input);
                                            break;
                                        case 2:
                                            System.out.println("Insira o texto da pergunta: ");
                                            input = scanner.next();
                                            //perguntas.get(1).setPergunta(input);
                                            break;
                                        case 3:
                                            System.out.println("Insira o texto da pergunta: ");
                                            input = scanner.next();
                                            //perguntas.get(2).setPergunta(input);
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

    private boolean verificarAlunosRodada(Turma turma) {
        boolean verificado = true;
        int i = 0;

        while(verificado && i < turma.getTamanhoTurma()){
            if(!turma.getAprendiz(i).getAvaliado()){
                verificado = false;
            }
            i++;
        }

        return verificado;
    }

    private boolean isPerguntasVazia() { //As 3 perguntas precisam ser preenchidas.
        boolean vazia = false;
        int i = 0;
        while (i < perguntasFacil.size() && !vazia) {
            if (perguntasFacil.get(i) == null) {
                vazia = true;
            }
            i++;
        }
        i = 0;
        while (i < perguntasMedia.size() && !vazia) {
            if (perguntasFacil.get(i) == null) {
                vazia = true;
            }
            i++;
        }
        i = 0;
        while (i < perguntasDificil.size() && !vazia) {
            if (perguntasFacil.get(i) == null) {
                vazia = true;
            }
            i++;
        }
        return vazia;
    }

    public void addPerguntas(){
        perguntasFacil.add(new Pergunta(1, "Quanto da 1+1?", 1)); //todo transformar em metodo
        perguntasFacil.add(new Pergunta(1, "Quanto da 5+5?", 2));
        perguntasFacil.add(new Pergunta(1, "Quanto da 2+2?", 3));
        perguntasMedia.add(new Pergunta(2, "Quanto da (1+1)^2?", 1));
        perguntasMedia.add(new Pergunta(2, "Quanto da (5+5)^2?", 2));
        perguntasMedia.add(new Pergunta(2, "Quanto da (2+2)^2?", 3));
        perguntasDificil.add(new Pergunta(3, "Quanto da (1+1)^3?", 1));
        perguntasDificil.add(new Pergunta(3, "Quanto da (5+5)^3?", 2));
        perguntasDificil.add(new Pergunta(3, "Quanto da (2+2)^3?", 3));
        perguntasFacil.get(0).inserirAlternativas("2", "1", "3");
        perguntasFacil.get(1).inserirAlternativas("5", "10", "15");
        perguntasFacil.get(2).inserirAlternativas("2", "4", "6");
        perguntasMedia.get(0).inserirAlternativas("4", "6", "8");
        perguntasMedia.get(1).inserirAlternativas("500", "100", "150");
        perguntasMedia.get(2).inserirAlternativas("6", "12", "16");
        perguntasDificil.get(0).inserirAlternativas("8", "4", "6");
        perguntasDificil.get(1).inserirAlternativas("100", "1000", "100000");
        perguntasDificil.get(2).inserirAlternativas("12", "32", "64");
    }

    //Setters
    private void setContRodada(int contRodada) {
        this.contRodada = contRodada;
    }
    private void setEscolhaAluno(int escolhaAluno) { this.escolhaAluno = escolhaAluno; }

    //Getters
    public int getContRodada() {
        return this.contRodada;
    }
    public int getEscolhaAluno() { return this.escolhaAluno; }

}
