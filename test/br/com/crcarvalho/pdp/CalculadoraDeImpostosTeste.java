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
	
}
