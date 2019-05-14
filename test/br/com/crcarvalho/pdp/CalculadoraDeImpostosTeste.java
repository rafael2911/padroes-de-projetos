package br.com.crcarvalho.pdp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.crcarvalho.pdp.CalculadoraDeImpostos;
import br.com.crcarvalho.pdp.ICCC;
import br.com.crcarvalho.pdp.ICMS;
import br.com.crcarvalho.pdp.ISS;
import br.com.crcarvalho.pdp.Orcamento;

public class CalculadoraDeImpostosTeste {
	
	@Test
	public void calculaImpostoICMS() {
		
		Orcamento orcamento = new Orcamento(500);
		CalculadoraDeImpostos calculadora = new CalculadoraDeImpostos();
		
		
		assertEquals(75.0, calculadora.calculaImpost(orcamento, new ICMS()), 0.00001);
	}
	
	@Test
	public void calculaImpostoISS() {
		
		Orcamento orcamento = new Orcamento(500);
		CalculadoraDeImpostos calculadora = new CalculadoraDeImpostos();
		
		assertEquals(30.0, calculadora.calculaImpost(orcamento, new ISS()), 0.00001);
	}
	
	@Test
	public void calculaImpostoICCCAbaixoDeMil(){
		
		Orcamento orcamento = new Orcamento(500);
		CalculadoraDeImpostos calculadora = new CalculadoraDeImpostos();
		
		assertEquals(25.0, calculadora.calculaImpost(orcamento, new ICCC()), 0.00001);
	}
	
	@Test
	public void calculaImpostoICCCAcimaDeTresMil(){
		
		Orcamento orcamento = new Orcamento(4000);
		CalculadoraDeImpostos calculadora = new CalculadoraDeImpostos();
		
		assertEquals(350.0, calculadora.calculaImpost(orcamento, new ICCC()), 0.00001);
	}
	
	@Test
	public void calculaImpostoICCCEntreMilETresMil(){
		
		// Sem fazer o uso da classe calculadoDeImpostos
		// Como a classe é utilizada apenas para retornar o valor do impostos calculado
		// seu uso não é necessário, mas haveram senários em que essa classe será necessária
		
		Orcamento orcamento = new Orcamento(1000);
		
		assertEquals(70.0, new ICCC().calcula(orcamento), 0.00001);
	}
	
	@Test
	public void calculaICPMaximaTaxacao() {
		Orcamento orcamento = new Orcamento(1000);
		
		assertEquals(70.0, new CalculadoraDeImpostos().calculaImpost(orcamento, new ICP()), 0.00001);
	}
	
	@Test
	public void calculaICPMinimaTaxacao() {
		Orcamento orcamento = new Orcamento(400);
		
		assertEquals(20.0, new CalculadoraDeImpostos().calculaImpost(orcamento, new ICP()), 0.00001);
	}
	
	@Test
	public void calculaIKCVMaximaTaxacao() {
		Orcamento orcamento = new Orcamento(800);
		orcamento.addItem(new Item("Casaco", 750.0));
		orcamento.addItem(new Item("Chinelo", 50.0));
		
		assertEquals(80.0, new CalculadoraDeImpostos().calculaImpost(orcamento, new IKCV()), 0.00001);
	}
	
	@Test
	public void calculaIKCVMinimaTaxacao() {
		Orcamento orcamento = new Orcamento(100);
		orcamento.addItem(new Item("Chinelo", 50.0));
		orcamento.addItem(new Item("Tenis", 50.0));
		
		assertEquals(6.0, new CalculadoraDeImpostos().calculaImpost(orcamento, new IKCV()), 0.00001);
	}
	
	@Test
	public void calculaIKCVMinimaTaxacaoOrcamentoAcimaEItemAbaixo() {
		Orcamento orcamento = new Orcamento(600);
		orcamento.addItem(new Item("Chinelo", 100.0));
		orcamento.addItem(new Item("Tenis", 100.0));
		orcamento.addItem(new Item("Sapato", 100.0));
		orcamento.addItem(new Item("Calça", 100.0));
		orcamento.addItem(new Item("Camisa", 100.0));
		orcamento.addItem(new Item("Boné", 100.0));
		
		assertEquals(36.0, new CalculadoraDeImpostos().calculaImpost(orcamento, new IKCV()), 0.00001);
	}
	
	@Test
	public void calculaIKCVMinimaTaxacaoOrcamentoAbaixoEItemAcima() {
		Orcamento orcamento = new Orcamento(300);
		orcamento.addItem(new Item("Chinelo", 200.0));
		orcamento.addItem(new Item("Tenis", 100.0));
		
		assertEquals(18.0, new CalculadoraDeImpostos().calculaImpost(orcamento, new IKCV()), 0.00001);
	}
	
	@Test
	public void calculaIHITMinimaTaxacao() {
		Orcamento orcamento = new Orcamento(400);
		orcamento.addItem(new Item("Chinelo", 200.0));
		orcamento.addItem(new Item("Tenis", 100.0));
		orcamento.addItem(new Item("Sapato", 100.0));
		
		assertEquals(12.0, new CalculadoraDeImpostos().calculaImpost(orcamento, new IHIT()), 0.00001);
	}
	
	@Test
	public void calculaIHITMaximaTaxacao() {
		Orcamento orcamento = new Orcamento(500);
		orcamento.addItem(new Item("Chinelo", 200.0));
		orcamento.addItem(new Item("Tenis", 100.0));
		orcamento.addItem(new Item("Chinelo", 200.0));
		
		assertEquals(165.0, new CalculadoraDeImpostos().calculaImpost(orcamento, new IHIT()), 0.00001);
	}
	
	@Test
	public void calculaImpostoComposto() {
		Orcamento orcamento = new Orcamento(500);
		Imposto imposto = new ISS(new ICMS());
		
		assertEquals(105.0, new CalculadoraDeImpostos().calculaImpost(orcamento, imposto), 0.00001);
	}
	
	@Test
	public void calculaImpostoCompostoImpostoMuitoAltoEISS() {
		Orcamento orcamento = new Orcamento(500);
		Imposto imposto = new ImpostoMuitoAlto(new ISS());
		
		assertEquals(130.0, new CalculadoraDeImpostos().calculaImpost(orcamento, imposto), 0.00001);
	}
	
}
