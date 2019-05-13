package br.com.crcarvalho.pdp;

public class CalculadoraDeImpostos {
	
	public double calculaImpost(Orcamento orcamento, Imposto imposto) {
		return imposto.calcula(orcamento);
	}
	
}
