package principal;

import java.util.Locale;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner teclado = new Scanner(System.in);
		
		int menu, quant;
		
		// menu
		System.out.println("---------------------------------\n      Bem-vindo ao Leilao\n---------------------------------\n");
		
		System.out.print("Primeiramente, informe a quantidade de lotes: ");
		quant = teclado.nextInt();
		Leilao leilao = new Leilao(quant);
		
		for (int i=0; i<leilao.getLotes().length; i++) {
			System.out.printf("%n%d_o Lote%n", i+1);
			System.out.print("Informe a quantidade de produtos: ");
			quant = teclado.nextInt();
			Lote lote = new Lote(quant);
			
			teclado.nextLine();
			for (int j=0; j<lote.getProdutos().length; j++) {
				System.out.printf("%d_o Produto%n", j+1);
				System.out.print("Descricao: ");
				String descricao = teclado.nextLine();
				
				System.out.print("O produto inserido tem algum valor minimo para que possa ser vendido, pressione ENTER caso nao tenha ou informe o valor: R$");
				
				String valorInicial = teclado.nextLine();
				Produto produto;
				
				if (!valorInicial.equals("")) {
					produto = new Produto(descricao, new Lance(Double.parseDouble(valorInicial)));
				} else {
					produto = new Produto(descricao, new Lance());
				}
				
				lote.inserirProduto(produto);
			}
			
			leilao.inserirLote(lote);
			System.out.println();
		}
		
		do {
			System.out.println("Menu");
			System.out.println("1. Receber Lance");
			System.out.println("2. Listar Produtos");
			System.out.println("3. Encerrar Leilao");
			System.out.print("->> ");
			menu = teclado.nextInt();
			
			switch (menu) {
			case 1:
				System.out.println("\nDados da pessoa");
				System.out.print("Nome: ");
				teclado.nextLine();
				String nome = teclado.nextLine();
				System.out.print("Contato: ");
				String contato = teclado.nextLine();
				Pessoa pessoa = new Pessoa(nome, contato);

				System.out.print("Informe o numero do lote e o valor do lance, respectivamente: ");
				int numLote = teclado.nextInt()-1;
				double valor = teclado.nextDouble();
				System.out.print("Tal lance vai para qual produto: ");
				teclado.nextLine();
				String descricao = teclado.nextLine();
				
				Lance lance = new Lance(pessoa, valor);
				leilao.receberLance(numLote, lance, descricao);
				break;
			case 2:
				System.out.println("\nProdutos disponiveis para leilao");
				leilao.listarProdutos();
				break;
			case 3:
				leilao.encerrarLeilao();
				break;
			}
			System.out.println();
		} while(menu != 3);
		
		teclado.close();		
	}
}
