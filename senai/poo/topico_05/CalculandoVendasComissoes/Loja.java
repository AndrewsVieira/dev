import java.util.Scanner;

public class Loja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // cadastrando os produtos
        double produto1 = 2.98;
        double produto2 = 4.50;
        double produto3 = 9.98;
        double produto4 = 4.49;
        double produto5 = 6.87;

        // colher informações do vendedor
        System.out.print("Digite o nome do vendedor: ");
        String nome = scanner.nextLine();

        Vendedor vendedor = new Vendedor(nome);

        System.out.println("Agora você irá cadastrar os produtos vendidos no mês.");

        // inicio do loop
        int numeroProduto = 0;
        boolean realizarVenda = true;
        boolean valido;
        while (realizarVenda) {

            System.out.print("Deseja realizar uma venda? (s/n): ");
            String resposta = scanner.nextLine();

            // resposta = resposta.toUpperCase();

            if (resposta.equals("n")) {
                realizarVenda = false;
                System.out.println("Obrigado.");
            } else if (resposta.equals("s")) {
                if (realizarVenda) {
                    System.out.print("Digite o número do produto: ");
                    numeroProduto = scanner.nextInt();

                    double produtoVendido;

                    switch (numeroProduto) {
                        case 1:
                            produtoVendido = produto1;
                            break;
                        case 2:
                            produtoVendido = produto2;
                            break;
                        case 3:
                            produtoVendido = produto3;
                            break;
                        case 4:
                            produtoVendido = produto4;
                            break;
                        case 5:
                            produtoVendido = produto5;
                            break;
                        default:
                            System.out.println("Produto não cadastrado.");
                            produtoVendido = 0.0;
                    }
                    
                    valido = numeroProduto >= 1 && numeroProduto <= 5;

                    if (valido) {

                        System.out.printf("Produto%d selecionado: R$ %.2f.%n", numeroProduto, produtoVendido);

                        System.out.print("Digite a quantidade vendida deste produto: ");
                        int quantidadeVendida = scanner.nextInt();

                        double venda = quantidadeVendida * produtoVendido;

                        if (venda > 0.0) {
                            System.out.printf("Valor da venda: R$ %.2f.%n", venda);
                            vendedor.setTotalVendas(venda);
                        }
                        scanner.nextLine();
                    }
                }
            }
        }

        // fim do loop

        System.out.printf("O vendedor %s alcançou uma venda de R$%.2f, seu salário no mês será R$%.2f%n",
                vendedor.getNome(), vendedor.getTotalVendas(), vendedor.getSalario(1045));

    }

}