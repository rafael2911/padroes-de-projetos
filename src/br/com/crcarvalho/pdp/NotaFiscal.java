package br.com.crcarvalho.pdp;

import java.util.Calendar;
import java.util.List;

public class NotaFiscal {

	private String razaoSocial;
	private String cnpj;
	private Calendar dataEmissao;
	private double valorBruto;
	private double imposto;
	private List<ItemDaNota> itens;
	private String observacoes;
	
	public NotaFiscal(String razaoSocial, String cnpj, Calendar dataEmissao, double valorBruto, double imposto,
			List<ItemDaNota> itens, String observacoes) {
		super();
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.dataEmissao = dataEmissao;
		this.valorBruto = valorBruto;
		this.imposto = imposto;
		this.itens = itens;
		this.observacoes = observacoes;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public Calendar getDataEmissao() {
		return dataEmissao;
	}

	public double getValorBruto() {
		return valorBruto;
	}

	public double getImposto() {
		return imposto;
	}

	public List<ItemDaNota> getItens() {
		return itens;
	}

	public String getObservacoes() {
		return observacoes;
	}
	
}
