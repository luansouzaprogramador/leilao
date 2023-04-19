package principal;

public class Lance {
	private Pessoa pessoa;
	private double valor;
	
	public Lance() {
		pessoa = new Pessoa();
		valor = 0.0;
	}

	public Lance(Pessoa pessoa, double valor) {
		this.pessoa = pessoa;
		this.valor = valor;
	}
	
	public Lance(double valorInicial) {
		pessoa = new Pessoa();
		this.valor = valorInicial;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public boolean equals(Lance lance) {
		if (pessoa.equals(lance.getPessoa()) && valor == lance.getValor())
			return true;
		
		return false;
	}
}
