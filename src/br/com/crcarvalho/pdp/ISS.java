package br.com.crcarvalho.pdp;

public class ISS extends Imposto {
	
	public ISS() {
		// TODO Auto-generated constructor stub
	}
	
	public ISS(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	public double calcula(Orcamento orcamento) {
		
		return orcamento.getValor() * 0.06 + calculoDoOutroImposto(orcamento);
	}
	
}
