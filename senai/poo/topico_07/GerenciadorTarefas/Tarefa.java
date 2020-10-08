//Tarefa.java - classe que cria as tarefas
public class Tarefa {
	private String nome; // nome é obrigatório
	private Data data; // data é opcional
	private Horario horario; // opcional também

	// construtor que recebe somenta o nome
	public Tarefa(String nome) {
		this.nome = nome;
	}

	// construtor que recebe nome e data
	public Tarefa(String nome, int dia, Mes mes, int ano) {
		this(nome);

		this.data = new Data(dia, mes, ano);
	}

	// construtor que recebe nome, data e horario
	public Tarefa(String nome, int dia, Mes mes, int ano, int hora, int minuto, int segundo) {
		this(nome, dia, mes, ano);

		this.horario = new Horario(hora, minuto, segundo);
	}

	public String toString() {
		if(this.data == null) {
			return String.format("Tarefa: %s.%n", this.nome);
		} else if(this.horario == null) {
			return String.format("Tarefa: %s, prazo: %s.%n", this.nome, this.data);
		}

		return String.format("Tarefa: %s, prazo: %s as %s.%n", this.nome, this.data,
				this.horario);
	}

}
