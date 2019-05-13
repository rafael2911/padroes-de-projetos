package br.com.crcarvalho.pdp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculadoraDeDescontosTeste {
	
	@Test
	public void testaDescontoAteCincoItens() {
		
		Orcamento orcamento = new Orcamento(500);
		orcamento.addItem(new Item("Bola", 250));
		orcamento.addItem(new Item("Caderno", 250));
		
		assertEquals(0, new CalculadoraDeDescontos().calcula(orcamento), 0.00001);
		
	}
	
	@Test
	public void testaDescontoAcimaDeCincoItens() {
		
		Orcamento orcamento = new Orcamento(600);
		orcamento.addItem(new Item("Bola", 100));
		orcamento.addItem(new Item("Caderno", 100));
		orcamento.addItem(new Item("Sapato", 100));
		orcamento.addItem(new Item("Chinelo", 100));
		orcamento.addItem(new Item("Casaco", 100));
		orcamento.addItem(new Item("Bone", 100));
		
		assertEquals(60.0, new CalculadoraDeDescontos().calcula(orcamento), 0.00001);
		
	}
	
	@Test
	public void testaDescontoValorAcimaDequinhentos() {
		
		Orcamento orcamento = new Orcamento(1000);
		orcamento.addItem(new Item("Bola", 300));
		orcamento.addItem(new Item("Caderno", 350));
		orcamento.addItem(new Item("Sapato", 350));

		
		assertEquals(70.0, new CalculadoraDeDescontos().calcula(orcamento), 0.00001);
		
	}
	
	@Test
	public void testaVendaCasada() {
		
		Orcamento orcamento = new Orcamento(240);
		orcamento.addItem(new Item("LAPIS", 20));
		orcamento.addItem(new Item("Caderno", 200));
		orcamento.addItem(new Item("CANETA", 20));

		
		assertEquals(12.0, new CalculadoraDeDescontos().calcula(orcamento), 0.00001);
		
	}
	
}
