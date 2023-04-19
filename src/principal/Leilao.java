package principal;

public class Leilao {
	private Lote[] lotes;
	// se eu colocasse posicao=0 aqui daria problema, ou so posso inicializar a posicao no construtor da classe?
	private int posicao;
	
	public Leilao(int quant) {
		lotes = new Lote[quant];
		posicao = 0;
	}
	
	public Lote[] getLotes() {
		return lotes;
	}

	public void setLotes(Lote[] lotes) {
		this.lotes = lotes;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public void inserirLote(Lote lote) {
		if (posicao < lotes.length) {
			lotes[posicao] = lote;
			posicao++;
		}
	}
	
	public void receberLance(int numLote, Lance lance, String descricaoProduto) {
		lotes[numLote].receberLance(lance, descricaoProduto);
	}
	
	public void listarProdutos() {
		for (int i=0; i<lotes.length; i++) {
			System.out.printf("%n%d_o Lote%n", i+1);
			for (int j=0; j<lotes[i].getProdutos().length; j++) {
				System.out.printf("%d_o produto%n", j+1);
				System.out.println("Descricao: "+lotes[i].getProdutos()[j].getDescricao());
				
				if (!lotes[i].getProdutos()[j].getMaiorLance().getPessoa().getNome().equals("")) {
					System.out.println("Maior lance: "+lotes[i].getProdutos()[j].getMaiorLance().getValor());
				}
			}
		}
	}
	
	public void encerrarLeilao() {
        int i = 0;
        for (Lote lote : lotes) {
            System.out.println("----------");
            System.out.println("Produtos do " + (i+1) + "_o lote:");
            i++;
            System.out.println("Descrição\t\t  \t\tArrematador\t\t\t\t  \t\t\t\tMaior Lance");
            for (Produto produto : lote.getProdutos()) {
                if (!(produto.getMaiorLance().getPessoa().getNome().equals("") || produto.getMaiorLance().getPessoa().getContato().equals("")))
                    System.out.println(produto.getDescricao() + "\t\t   \t\t" + produto.getMaiorLance().getPessoa().getNome() + " (" +
                produto.getMaiorLance().getPessoa().getContato() + ")" + "\t\t\t\t  \t\t\t\tR$" + produto.getMaiorLance().getValor());
            }
        }
    }
}
