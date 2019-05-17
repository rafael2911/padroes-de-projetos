package br.com.crcarvalho.pdp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NotaFiscalBuilder {

	private String nomeEmpresa;
	private String cnpj;
	private List<ItemDaNota> itens = new ArrayList<>();
	private double valorBruto;
	private double imposto;
	private String observacoes;
	private Calendar data;

	public NotaFiscalBuilder() {
		this.data = Calendar.getInstance();
	}
	
	public NotaFiscalBuilder paraEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
		return this;
	}

	public NotaFiscalBuilder comCNPJ(String cnpj) {
		this.cnpj = cnpj;
		return this;
	}

	public NotaFiscalBuilder com(ItemDaNota itemDaNota) {
		this.itens.add(itemDaNota);
		this.valorBruto += itemDaNota.getValor();
		this.imposto = valorBruto * 0.05;
		
		return this;
	}

	public NotaFiscalBuilder comObservacoes(String observacoes) {
		this.observacoes = observacoes;
		return this;
	}

	public NotaFiscalBuilder naData(Calendar novaData) {
		this.data = novaData;
		return this;
	}
	
	public NotaFiscal constroi() {
		return new NotaFiscal(nomeEmpresa, cnpj, data, valorBruto, imposto, itens, observacoes);
	}
	
}
