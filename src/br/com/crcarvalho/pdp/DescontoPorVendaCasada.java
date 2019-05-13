package br.com.crcarvalho.pdp;

public class DescontoPorVendaCasada implements Desconto {

	private Desconto proximo;

	@Override
	public double desconta(Orcamento orcamento) {
		
		if(aconteceuVendaCasada(orcamento)) {
			return orcamento.getValor() * 0.05;
		}
		
		return proximo.desconta(orcamento);
	}	

	private boolean aconteceuVendaCasada(Orcamento orcamento) {
		return existe("CANETA", orcamento) && existe("LAPIS", orcamento);
	}

	private boolean existe(String nomeDoItem, Orcamento orcamento) {
		
		for(Item item : orcamento.getItens()) {
			if(item.getItem().equals(nomeDoItem)) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
	}

}
