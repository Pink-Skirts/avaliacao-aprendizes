# Projeto Avaliação de Aprendizes
# Sobre o projeto
Baseado em java, tem como objetivo implementar o modelo-exemplo, proposto na disciplina de Laboratório de Modelagem Algorítmica (LMA), do curso de Ciência da Computação da Pontifícia Universidade Católica de São Paulo.

O sistema permite que o usuário crie turmas de aprendizes, nas quais serão avaliadas por meio de perguntas, categorizadas em três níveis:
1. Fácil
2. Média
3. Difícil

Ao selecionar uma turma, um aluno dessa turma será sorteado para responder três perguntas, o que caracteriza o início de uma rodada.

## Rodada
Uma rodada possui 3 perguntas, e finaliza caso o aluno queira parar, termine de responder todas as perguntas, selecione uma alternativa incorreta (errar a pergunta), ou se pedir ajuda a um colega da mesma turma, no qual também será sorteado.

É iniciada por uma pergunta sorteada fácil, seguida de uma média, e por fim, uma difícil. 

Caso o aluno desista da questão em que parou, o mesmo irá receber a pontuação até onde conseguiu responder corretamente, seguindo a tabela de pontos:

 Dificuldade | Pontuação
 ----------- | ------
 Fácil       | 4
 Média       | 7
 Difícil     | 10

Nota-se que não se trata de uma somatória, e sim do acúmulo da nota do aluno em questão.

Ao ser finalizada, uma opção de iniciar outra rodada é apresentada, e outro aluno, diferente dos que já foram avaliados, da mesma turma, será sorteado para dar início 
à resolução das perguntas.

## Ajuda
Em uma ajuda, o aluno que for sorteado para ajudar o colega que o solicitou, é o responsável por resolver a questão. Caso a erre, ambos os alunos ficarão com a nota já acumulada da rodada, seja tal determinada pelo primeiro aluno.

## Interface
A interface do projeto é feita pelo Terminal. 

### Menu Inicial:

![Menu Inicial](https://raw.githubusercontent.com/Pink-Skirts/avaliacao-aprendizes/screenshots/menu-inicial.png)

A partir dela, temos as opções:
1. Iniciar rodada - Requere que o usuário selecione uma turma a ser avaliada, e então segue para o menu de rodadas.
2. Criar turma de aprendizes - Permite o usuário criar uma turma a ser avaliada. É necessário selecionar esta opção antes de iniciar um rodada, pelo motivo de ser impossível avaliar uma turma, sem ela existir.
3. Mostrar aprendizes - Mostra todos os aprendizes, de uma determinada turma. Tal turma é escolhida pelo usuário.
4. Configurações - Abre o menu de configurações do sistema.
5. Sair - Sai do programa.

### Menu de Opções:

![Menu opções](https://raw.githubusercontent.com/Pink-Skirts/avaliacao-aprendizes/screenshots/menu-edicao.png)

1. Remover aluno de uma turma - Remove um aluno de uma turma. Requere que o usuário selecione uma turma, e então, o aluno a ser removido.
2. Adicionar aluno a uma turma - Adiciona um aluno a uma turma. Requere que o usuário selecione uma turma, e então, o aluno a ser adicionado.
3. Mudar o nome de um aluno - Modifica o nome do aluno. Requere que o usuário selecione uma turma, e então, o aluno a ser modificado.
4. Excluir uma turma - Exclui uma turma do armazenador de turmas. Requere que o usuário selecione uma turma.
5. Sair - Sair do menu de opções e voltar ao menu inicial.

## Modelo Conceitual
### Diagrama de caso:
![Diagrama de caso](https://raw.githubusercontent.com/Pink-Skirts/avaliacao-aprendizes/screenshots/diagrama-de-caso.png)

### Diagrama de classe:
![Diagrama de classe](https://raw.githubusercontent.com/Pink-Skirts/avaliacao-aprendizes/screenshots/diagrama-de-classes.png)

## Técnicas e tecnologias utilizadas
* Java 18
* IntelliJ IDEA
* BlueJ

## Conclusões:
- **Guilherme:** Sinceramente, é a primeira vez que é pedido um projeto junto com uma documentação e um modelo, por isso houve algumas dificuldades na minha visão geral, já que era a primeira vez fazendo algo assim. Independente de tudo, posso dizer que aprendi coisas novas, vi coisas que preciso melhorar e espero que no próximo projeto eu possa fazer algo melhor.

- **Gustavo:** É importante frisar que, o aprendizado em projetos de pequeno porte é uma excelente maneira de começar aprender a como programar de verdade, e trabalhar em equipe da forma correta. A organização das classes foi algo que me pressionou a encapsular métodos, e diminuir a quantidade de instruções já inseridas em um método maior. O nível de dificuldade do modelo proposto foi de nível adequado, visto que a implementação do próprio se mostrou fluida e interessante. 

- **Pietro:** Eu e meu grupo sofremos muitos desafios para desenvolver esse pequeno projeto, não por sua dificuldade, mas pela necessidade de implementar uma lógica bem fundamentada e por consolidar ideias de todos os integrantes do grupo. Assim, mesmo com os desafios que sofremos, eu acredito que todos nós aprendemos muito, principalmente com as dificuldades de trabalho em equipe, e então, usarei os erros que cometi e os ensinamentos dos meus colegas, para desenvolver melhores projetos no futuro.

## Autores
* Guilherme Monteiro de Oliveira
* Gustavo Scaglione Vilmar
* Pietro Tadeu Vieira Giorgi

#### Para mais informações ou contribuir com o projeto, veja o repositório no github: https://github.com/Pink-Skirts/avaliacao-aprendizes
