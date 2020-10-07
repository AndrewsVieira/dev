// Classe filha de Conta - deve permitir aplicar um rendimento mensal e cobrar o IR anual.

public class Investimento extends Conta {
    public static final double RENDIMENTO_MENSAL = 0.01; // a.m
    public static final double IR = 0.15; // a.a e sobre o lucro
    private double lucro;
    private double saldoInicial;

    public Investimento(String nome, int numero, double saldo) {
        super(nome, numero, saldo);

        this.saldoInicial = saldo;
    }

    private void setLucro() {
        this.lucro = getSaldo() - this.saldoInicial;
    }

    public void aplicarRendimentoMensal(int meses) {
        for (int i = 1; i <= meses; i++) {
            setSaldo((getSaldo() * RENDIMENTO_MENSAL + getSaldo()));
        }
    }

    public void cobrarIR() {
        setLucro();
        setSaldo(getSaldo() - (this.lucro * IR));
    }
}
