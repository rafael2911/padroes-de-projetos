package br.com.crcarvalho.pdp;

public abstract class Imposto {
	
	protected Imposto outroImposto;
	
	public Imposto() {}
	
	public Imposto(Imposto outroImposto) {
		this.outroImposto = outroImposto;
	}
	
	protected double calculoDoOutroImposto(Orcamento orcamento) {
		if(outroImposto == null)
			return 0;
		
		return outroImposto.calcula(orcamento);
	}
	
	public abstract double calcula(Orcamento orcamento);
	
}
