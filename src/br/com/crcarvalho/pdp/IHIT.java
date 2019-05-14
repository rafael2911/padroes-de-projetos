package br.com.crcarvalho.pdp;

import java.util.ArrayList;
import java.util.List;

public class IHIT extends TemplateDeImpostoCondicional {

	@Override
	protected double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.01 * orcamento.getItens().size();
	}

	@Override
	protected double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.13 + 100;
	}

	@Override
	protected boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		return existeDoisItensComOMesmoNome(orcamento);
	}

	private boolean existeDoisItensComOMesmoNome(Orcamento orcamento) {
		List<String> noOrcamento = new ArrayList<>();
		
		for (Item item : orcamento.getItens()) {
			if(noOrcamento.contains(item.getItem())) {
				return true;
			}
			noOrcamento.add(item.getItem());
		}
		
		return false;
	}

}
