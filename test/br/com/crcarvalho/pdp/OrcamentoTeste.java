package br.com.crcarvalho.pdp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OrcamentoTeste {
	
	@Test
	public void testaDescontoExtraEmAprovacao() {
		Orcamento reforma = new Orcamento(500);
		
		reforma.aplicaDescontoExtra();
		
		assertEquals(475.0, reforma.getValor(), 0.00001);
	}
	
	@Test
	public void testaDescontoExtraAprovado() {
		Orcamento reforma = new Orcamento(500);
		
		reforma.aprova();
		
		reforma.aplicaDescontoExtra();
		
		assertEquals(490.0, reforma.getValor(), 0.00001);
	}
	
	@Test(expected = RuntimeException.class)
	public void testaDescontoJaAplicado() {
		Orcamento reforma = new Orcamento(500);
		
		reforma.aplicaDescontoExtra();
		
		reforma.aplicaDescontoExtra();
		
		assertEquals(490.0, reforma.getValor(), 0.00001);
	}
	
}
