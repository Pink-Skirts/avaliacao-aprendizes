/*  title: Rodada.java
 *  subtitle: Laboratorio de Modelagem (LMA)
 *  authors: Guilherme Monteiro de Oliveira, Gustavo Scaglione Vilmar, Pietro Tadeu Vieira Giorgi
 *  date: Sun Nov 20 15:26:26 2022:
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Rodada {
    private int contRodada;
    private boolean rodadaAjuda = false;
    private int indiceAprendizAjuda;
    private Pergunta perguntaAjuda;
    private boolean parar = false;
    private boolean saida = false;

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

    public Rodada(Turma turma, int rodada, Pergunta pergunta, int indice) {
        rodadaAjuda = true;
        this.indiceAprendizAjuda = indice;
        this.perguntaAjuda = pergunta;
        setContRodada(rodada);
        iniciarRodada(turma);
    }

    public void iniciarRodada(Turma turma) {
        addPerguntas();
        int x;
        Aplicacao.limparTela();
        while (!getSaida()) {

            if (!getRodadaAjuda()) {
                System.out.println("Escolha uma opcao: \n" +
                        "1 - Comecar (Sortear um aprendiz e pergunta)\n" +
                        "2 - Voltar para o menu");
            }

            int escolha;

            if (!getRodadaAjuda()) {
                escolha = scanner.nextInt();
            } else {
                escolha = 1;
            }

            switch (escolha) {
                case 1:
                    Pergunta perguntaAux;
                    int indicePerguntaEscolhida;
                    int indiceAlunoEscolhido;
                    boolean presente;
                    if ((!isPerguntasVazia() && !verificarAlunosRodada(turma)) || getRodadaAjuda()) {
                        if (!getRodadaAjuda()) {
                            indiceAlunoEscolhido = sortearAluno(turma);
                            System.out.println("Aluno escolhido: " + turma.getAprendiz(indiceAlunoEscolhido).getNome());
                            presente = verificarPresenca();
                            setContRodada(0);
                        } else {
                            indiceAlunoEscolhido = indiceAprendizAjuda;
                            System.out.println("Aluno escolhido: " + turma.getAprendiz(indiceAlunoEscolhido).getNome());
                            presente = verificarPresenca();
                        }
                        if(!presente){
                            setParar(true);
                            turma.getAprendiz(indiceAlunoEscolhido).setAvaliado(true);
                        }
                        while (!getParar() && getContRodada() < 3 && presente) {
                            if (getContRodada() == 0) {
                                indicePerguntaEscolhida = Sorteio.sortearPergunta(perguntasFacil.size());
                                if (!getRodadaAjuda()) {
                                    perguntaAux = perguntasFacil.get(indicePerguntaEscolhida);
                                } else {
                                    perguntaAux = perguntaAjuda;
                                }
                            } else if (getContRodada() == 1) {
                                indicePerguntaEscolhida = Sorteio.sortearPergunta(perguntasMedia.size());
                                if (!getRodadaAjuda()) {
                                    perguntaAux = perguntasMedia.get(indicePerguntaEscolhida);
                                } else {
                                    perguntaAux = perguntaAjuda;
                                }
                            } else {
                                indicePerguntaEscolhida = Sorteio.sortearPergunta(perguntasDificil.size());
                                if (!getRodadaAjuda()) {
                                    perguntaAux = perguntasDificil.get(indicePerguntaEscolhida);
                                } else {
                                    perguntaAux = perguntaAjuda;
                                }
                            }
                            System.out.println("Pergunta sorteada: " + perguntaAux.getPergunta());

                            System.out.println("Escolha uma alternativa: ");
                            perguntaAux.mostrarAlternativas();

                            x = scanner.nextInt();
                            if (x == perguntaAux.getResposta()) {
                                Avaliacao avaliacao = new Avaliacao();
                                System.out.println("Voce acertou!");
                                if (getContRodada() == 0) {
                                    avaliacao.avaliar1(turma, indiceAlunoEscolhido);
                                    if (rodadaAjuda) {
                                        rodadaAjuda = false;
                                    }
                                } else if (getContRodada() == 1 && turma.getAprendiz(indiceAlunoEscolhido).getNota()
                                        == 4) {
                                    avaliacao.avaliar2(turma, indiceAlunoEscolhido);
                                    if (rodadaAjuda) {
                                        rodadaAjuda = false;
                                    }
                                } else if (getContRodada() == 2 && turma.getAprendiz(indiceAlunoEscolhido).getNota()
                                        == 7) {
                                    avaliacao.avaliar3(turma, indiceAlunoEscolhido);
                                    if (rodadaAjuda) {
                                        rodadaAjuda = false;
                                        parar = true;
                                        saida = true;
                                    }
                                }
                                setContRodada(getContRodada() + 1);
                            } else if (x == 5) {
                                if (!rodadaAjuda) {
                                    turma.getAprendiz(indiceAlunoEscolhido).setAvaliado(true);
                                    if (!verificarAlunosRodada(turma)) {
                                        int indiceAprendiz = sortearAluno(turma);
                                        new Ajuda(turma, indiceAprendiz, perguntaAux, getContRodada());
                                        turma.getAprendiz(indiceAlunoEscolhido).setNota(turma.getAprendiz(indiceAprendiz).getNota());
                                        parar = true;
                                        saida = true;
                                    } else {
                                        System.out.println("Não existe aluno disponivel para ajudar");
                                    }
                                } else {
                                    System.out.println("A opção de ajuda ja foi utilizada");
                                }
                            } else if (x == 6) {
                                Parada parada = new Parada(turma, indiceAlunoEscolhido, getContRodada());
                                parar = parada.pararRodada();
                                parada.contabilizarPontos();
                                turma.getAprendiz(indiceAlunoEscolhido).setAvaliado(true);
                            } else {
                                turma.getAprendiz(indiceAlunoEscolhido).setAvaliado(true);
                                System.out.println("Resposta incorreta!");
                                parar = true;
                            }
                        }
                    } else {
                        System.out.println("Configuracoes insuficientes!");
                        saida = true;
                    }
                    break;
                case 2:
                    saida = true;
                    break;
                default:
                    break;
            }
        }
    }

    private int sortearAluno(Turma turma) {
        int indiceAlunoEscolhido;
        do {
            indiceAlunoEscolhido = Sorteio.sortearAluno(turma.getTamanhoTurma());
        } while (turma.getAprendiz(indiceAlunoEscolhido).getAvaliado());

        return indiceAlunoEscolhido;
    }

    private boolean verificarAlunosRodada(Turma turma) {
        boolean verificado = true;
        int i = 0;

        while (verificado && i < turma.getTamanhoTurma()) {
            if (!turma.getAprendiz(i).getAvaliado()) {
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

    public void addPerguntas() {
        perguntasFacil.add(new Pergunta(1, "Quanto da 1+1?", 1));
        perguntasFacil.add(new Pergunta(1, "Quanto da 5+5?", 2));
        perguntasFacil.add(new Pergunta(1, "Quanto da 2+2?", 3));
        perguntasMedia.add(new Pergunta(2, "Quanto da (1+1)^2?", 1));
        perguntasMedia.add(new Pergunta(2, "Quanto da (5+5)^2?", 2));
        perguntasMedia.add(new Pergunta(2, "Quanto da (2+2)^2?", 3));
        perguntasDificil.add(new Pergunta(3, "Quanto da (1+1)^3?", 1));
        perguntasDificil.add(new Pergunta(3, "Quanto da (5+5)^3?", 2));
        perguntasDificil.add(new Pergunta(3, "Quanto da (2+2)^3?", 3));
        perguntasFacil.get(0).inserirAlternativas("2", "1", "3", "25");
        perguntasFacil.get(1).inserirAlternativas("5", "10", "15", "6");
        perguntasFacil.get(2).inserirAlternativas("2", "4", "6", "8");
        perguntasMedia.get(0).inserirAlternativas("4", "6", "8", "10");
        perguntasMedia.get(1).inserirAlternativas("500", "100", "150", "14");
        perguntasMedia.get(2).inserirAlternativas("6", "12", "16", "14");
        perguntasDificil.get(0).inserirAlternativas("8", "4", "6", "2");
        perguntasDificil.get(1).inserirAlternativas("100", "1000", "100000", "10");
        perguntasDificil.get(2).inserirAlternativas("12", "32", "64", "128");
    }

    //Setters
    public void setContRodada(int contRodada) {
        this.contRodada = contRodada;
    }

    public void setRodadaAjuda(boolean rodadaAjuda) {
        this.rodadaAjuda = rodadaAjuda;
    }

    public void setParar(boolean parar) {
        this.parar = parar;
    }

    public void setSaida(boolean saida) {
        this.saida = saida;
    }

    //Getters
    public int getContRodada() {
        return this.contRodada;
    }

    public boolean getRodadaAjuda() {
        return this.rodadaAjuda;
    }

    public boolean getParar() {
        return this.parar;
    }

    public boolean getSaida() {
        return this.saida;
    }

    public boolean verificarPresenca(){
        boolean presente = false;
        System.out.println("O aluno esta presente?:\n" +
                "1 - Sim\n" +
                "2 - Nao\n");
        int x = scanner.nextInt();
        if (x == 1){
            presente = true;
        }
        return presente;
    }
}
