public class Pizzaria {
	public static void main(String[] args) {
		Pizza[] pizzas = new Pizza[4];
		pizzas[0] = new Pepperoni("Pepperoni", Tamanho.GRANDE);
		pizzas[1] = new Margherita("Margherita", Tamanho.MEDIA);
		pizzas[2] = new Mussarela("Mussarela", Tamanho.GIGANTE);
		pizzas[2] = new Portuguesa("Portuguêsa", Tamanho.BROTO);

		for(Pizza pizza : pizzas) {
			pizza.preparar();
			pizza.assar();
			pizza.cortar();
			System.out.println(pizza);
		}
	}
}
