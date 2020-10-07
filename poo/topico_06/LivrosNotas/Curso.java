public class Curso {
    public static void main(String[] args) {
        //A classe Curso deve receber 3 argumentos de linha de comando: o nome da UC, o número de alunos e o número de avaliações. Se o número de argumentos for diferente de 3, deve exibir uma mensagem e sair do programa;
        if (args.length == 3) {
            //O método main deve solicitar a exibição da mensagem de boas vindas para a classe Tela, deve criar um livro de notas, deve solicitar as notas para cada avaliação de cada aluno, adicionando ao livro de notas, deve exibir as médias de todos os alunos e, por fim, exibir a média do primeiro aluno do livro de notas;
            Tela.boasVindas();
            String nomeUC = args[0];
            int numAlunos = Integer.parseInt(args[1]);
            int numAvaliacoes = Integer.parseInt(args[2]);
            LivroNotas livroNota = new LivroNotas(nomeUC, numAlunos, numAvaliacoes);

            for (int i = 0; i < numAlunos; i++) {
                for (int j = 0; j < numAvaliacoes; j++){
                    double nota = Tela.pedirNota(i);
                    livroNota.adicionarNota(nota, i, j);
                }                
            }
            System.out.println();

            Tela.imprimeMedias(livroNota.calcularMediaPorAluno(), livroNota.getNomeUC());

            System.out.println();

            int idAluno01 = 0;
            
            Tela.imprimeMedia(livroNota.calcularMediaPorAluno(idAluno01), livroNota.getNomeUC(), idAluno01);

        } else {
            System.out.println("O número de argumentos de linha de comando devem ser 3. Abortando!");
        }//fim do if e else
    }//fim do método main
}//fim da classe Curso