package br.com.crcarvalho.pdp;

public class ICMS extends Imposto {

	public ICMS() {
		// TODO Auto-generated constructor stub
	}
	
	public ICMS(Imposto outroImposto) {
		super(outroImposto);
	}
	
	public double calcula(Orcamento orcamento) {
		
		return (orcamento.getValor() * 0.05 + 50) + calculoDoOutroImposto(orcamento);
	}

}
