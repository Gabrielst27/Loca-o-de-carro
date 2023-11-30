package services;

import entities.Fatura;
import entities.Locação;

public class ServiçoLocação {
	
	private Double valorPorHora;
	private Double valorPorDia;
	
	private TaxaBrasil taxa;

	public ServiçoLocação(Double valorPorHora, Double valorPorDia, TaxaBrasil taxa) {
		this.valorPorHora = valorPorHora;
		this.valorPorDia = valorPorDia;
		this.taxa = taxa;
	}
	
	public void gerarFatura(Locação locação) {
		locação.setFatura(new Fatura(50.0, 10.0));
	}

}
