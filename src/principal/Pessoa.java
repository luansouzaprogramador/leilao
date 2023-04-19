package principal;

public class Pessoa {
	private String nome;
	private String contato;
	
	public Pessoa() {
		nome = "";
		contato = "";
	}
	
	public Pessoa(String nome, String contato) {
		this.nome = nome;
		this.contato = contato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}
	
	public boolean equals(Pessoa pessoa) {
		if (nome.equals(pessoa.getNome()) && contato.equals(pessoa.getContato()))
			return true;
		
		return false;
	}
}
