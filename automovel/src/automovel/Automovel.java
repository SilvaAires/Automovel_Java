package automovel;

public class Automovel {
	private int id;
	private String marca;
	private String modelo;
	private int ano;
	
	public Automovel() {}			
	
	public Automovel(String marca, String modelo, int ano) {		
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
	}
	

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String toString() {
		return "ID: " + this.id + " Marca: " + this.marca + " Modelo: " + this.modelo + " Ano: " + this.ano + "\n";
	}
	
	public String[] toTabela() {
		return new String[] {this.id+"",this.marca, this.modelo, this.ano+""};
	}
}
