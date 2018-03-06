package com.example.algamoneyapi.repository.filter;

import java.time.LocalDate;


import org.springframework.format.annotation.DateTimeFormat;

public class LancamentoFilter {
	
	private String descricao;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataVencimentoDe;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataVenciementoAte;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String decricao) {
		this.descricao = decricao;
	}
	public LocalDate getDataVencimentoDe() {
		return dataVencimentoDe;
	}
	public void setDataVencimentoDe(LocalDate dataVencimentoDe) {
		this.dataVencimentoDe = dataVencimentoDe;
	}
	public LocalDate getDataVenciementoAte() {
		return dataVenciementoAte;
	}
	public void setDataVenciementoAte(LocalDate dataVenciemntoAte) {
		this.dataVenciementoAte = dataVenciemntoAte;
	}

}
