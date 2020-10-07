// Curso.java
// Utiliza a classe LivroNotas para calcular a média de notas de uma turma.

public class Curso {
    public static void main(String[] args) {
        LivroNotas livroNotas = new LivroNotas("Programação Orientada a Objetos");

        livroNotas.exibirMensagem();
        livroNotas.calcularMediaAlunos(5);
    }// fim do método main
}// fim da classe Curso