package br.com.crcarvalho.pdp;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

public class NotaFiscalTeste {
	
	@Test
	public void testaCriacaoDeNotaFiscalSemBuilder() {
		List<ItemDaNota> itens = Arrays.asList(new ItemDaNota("Bola", 90.0), new ItemDaNota("Camisa", 120.0));
		
		double valorBruto = itens.stream().mapToDouble(i -> i.getValor()).sum();
		double imposto = valorBruto * 0.05;
		
		
		NotaFiscal nota = new NotaFiscal(
				"CR Tecnology",
				"123.456.789/0001.10",
				Calendar.getInstance(),
				valorBruto,
				imposto,
				itens,
				"Criação nota de teste");
		
		assertEquals(210.0, nota.getValorBruto(), 0.00001);
		assertEquals(10.5, nota.getImposto(), 0.00001);
	}
	
	@Test
	public void testaCriacaoDeNotaFiscalComBuilder() {
		
		NotaFiscal nota = new NotaFiscalBuilder()
			.paraEmpresa("CR Tecnology")
			.comCNPJ("123.456.789/0001.10")
			.com(new ItemDaNota("Bole", 90.0))
			.com(new ItemDaNota("Camisa", 120.0))
			.comObservacoes("Criação nota de teste")
			.constroi();
		
		assertEquals(210.0, nota.getValorBruto(), 0.00001);
		assertEquals(10.5, nota.getImposto(), 0.00001);
	}
	
}
