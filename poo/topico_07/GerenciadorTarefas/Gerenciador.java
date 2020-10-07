public class Gerenciador {
	public static void main(String[] args) {
		Tarefa tarefa1 = new Tarefa("Escrever a tarefa 1");

		Tarefa tarefa2 = new Tarefa("Escrever a tarefa 2", 30, Mes.SETEMBRO, 2020);

		Tarefa tarefa3 = new Tarefa("Escrever a tarefa 3", 28, Mes.FEVEREIRO, 2018, 14, 40, 59);

		System.out.printf("%s%n", tarefa1);
		System.out.printf("%s%n", tarefa2);
		System.out.printf("%s%n", tarefa3);

	}// fim do main

}// fim da classe
