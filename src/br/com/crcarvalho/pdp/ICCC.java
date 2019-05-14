package br.com.crcarvalho.pdp;

public class ICCC extends Imposto {
	
	public ICCC() {}
	
	public ICCC(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	public double calcula(Orcamento orcamento) {
		
		if(orcamento.getValor() < 1000) {
			return orcamento.getValor() * 0.05 + calculoDoOutroImposto(orcamento);
			
		}
		
		if(orcamento.getValor() <= 3000) {
			return orcamento.getValor() * 0.07 + calculoDoOutroImposto(orcamento);
		}
		
		return orcamento.getValor() * 0.08 + 30 + calculoDoOutroImposto(orcamento);
	}

}
