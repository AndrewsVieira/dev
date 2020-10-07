// classe LivroNotas

public class LivroNotas {

    //Considere que a classe LivroNotas possui os atributos nomeUC e notas, sendo que o atributo notas é um array bidimensional de double;

    private String nomeUC;
    private double[][] notas;

    //O construtor da classe LivroNotas deve receber como parâmetros o nome da UC (nomeUC), o número de alunos (numAlunos) e o número de avaliações (numAvaliações), que devem ser utilizados para inicializar os atributos da classe;
    int numAvaliacoes;

    public LivroNotas(String nomeUC, int numAlunos, int numAvaliacoes) {
        this.nomeUC = nomeUC;
        this.numAvaliacoes = numAvaliacoes;
        notas = new double[numAlunos][this.numAvaliacoes];
    }

    public String getNomeUC() {
        return this.nomeUC;
    }

    // A classe LivroNotas deve possuir um método adicionarNota, para incluir uma nota no livro para um determinado aluno (idAluno) e avaliação (idAvaliacao);

    public void adicionarNota(double nota, int idAluno, int idAvaliacao) {
        notas[idAluno][idAvaliacao] = nota;
    }

    // classe LivroNotas deve oferecer dois métodos chamados calcularMediaPorAluno (métodos sobrecarregados). Um dos métodos não recebe parâmetros e calcula e retorna a média das notas de cada aluno como um array de double. O outro método calcula e retorna a média das notas para um aluno específico (idAluno);

    public double[] calcularMediaPorAluno() {
        double[] medias = new double[this.notas.length];

        for (int i = 0; i < medias.length; i++) {
            double soma = 0.0;
            for (int j = 0; j < this.numAvaliacoes ; j++) {
                soma += notas[i][j];
            }
            medias[i] = soma / this.numAvaliacoes;
        }

        return medias;
    }

    public double calcularMediaPorAluno(int idAluno) {
        double[] medias = this.calcularMediaPorAluno();
        return medias[idAluno];
    }

}// fim da classe LivroNotas

