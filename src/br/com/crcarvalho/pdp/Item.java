package br.com.crcarvalho.pdp;

public class Item {
	
	private String item;
	private double valor;
	
	public Item(String item, double valor) {
		this.item = item;
		this.valor = valor;
	}
	
	public String getItem() {
		return item;
	}
	
	public double getValor() {
		return valor;
	}
	
}
