package br.com.crcarvalho.pdp;

public interface Desconto {
	
	double desconta(Orcamento orcamento);
	void setProximo(Desconto proximo);
	
}
