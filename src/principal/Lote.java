package principal;

public class Lote {
	private Produto[] produtos;
	private int posicao;
	
	public Lote(int quant) {
		produtos = new Produto[quant];
		posicao = 0;
	}
	
	public Produto[] getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto[] produtos) {
		this.produtos = produtos;
	}
	
	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public void inserirProduto(Produto produto) {
		if (posicao < produtos.length) {
			produtos[posicao] = produto;
			posicao++;
		}
	}
	
	public void receberLance(Lance lance, String descricao) {
		pesquisarProduto(descricao).setMaiorLance(lance);
	}
	
	public Produto pesquisarProduto(String descricao) {
		for (int i=0; i<produtos.length; i++)
			if (produtos[i].getDescricao().equals(descricao))
				return produtos[i];
		
		return null;
	}
}
