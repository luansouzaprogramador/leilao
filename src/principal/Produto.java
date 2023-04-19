package principal;

public class Produto {
	private String descricao;
	private Lance maiorLance;
	
	public Produto() {
		descricao = "";
		maiorLance = new Lance();
	}

	public Produto(String descricao, Lance maiorLance) {
		this.descricao = descricao;
		this.maiorLance = maiorLance;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Lance getMaiorLance() {
		return maiorLance;
	}

	public void setMaiorLance(Lance lance) {
		if (lance.getValor()!=0 && lance.getValor() >= maiorLance.getValor() && !(lance.getPessoa().getNome().equals("") || lance.getPessoa().getContato().equals("")))
			maiorLance = lance;
	}
}
