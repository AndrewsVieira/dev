// Classe filha de Conta - deve permitir aplicar um rendimento mensal, de percentual fixo

public class Poupanca extends Conta {
    public static final double JUROS_POUPANCA = 0.05; // a.a

    public Poupanca(String nome, int numero, double saldo) {
        super(nome, numero, saldo);
    }

    public double aplicarRendimentoMensal(int meses) {
        for (int i = 1; i <= meses; i++) {
            setSaldo((getSaldo() * (JUROS_POUPANCA / 12) + getSaldo()));
        }

        return getSaldo();
    }
}