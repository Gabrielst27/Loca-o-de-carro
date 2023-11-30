package services;

import java.time.Duration;

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
		
		double minutos = Duration.between(locação.getInício(), locação.getFim()).toMinutes();
		double horas = minutos / 60.0;
		
		double valorBase;
		if(horas <= 12) {
			valorBase = valorPorHora * Math.ceil(horas);
		} else {
			valorBase = valorPorDia * Math.ceil(horas/24.0);
		}
		
		double tx = taxa.taxa(valorBase);
		
		locação.setFatura(new Fatura(valorBase, tx));
	}

}
