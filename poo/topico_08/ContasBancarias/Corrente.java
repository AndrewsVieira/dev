// Classe filha de Conta - deve permitir pagar contas e cobrar uma tarifa mensal
public class Corrente extends Conta{
    public static final double TARIFA = 25.00; // mensais

    public Corrente(String nome, int numero, double saldo) {
        super(nome, numero, saldo);
    }

    public void pagarConta(double valor) {
        setSaldo(getSaldo()-valor);
    }

    public void descontarTarifa(int meses) {
        setSaldo(getSaldo() - (TARIFA * meses));
    }
}
