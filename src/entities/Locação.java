package entities;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Locação {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	private LocalDateTime dataInicial;
	private LocalDateTime dataFinal;
	private Double valorPorHora;
	private Double valorPorDia;

	private Veículo modelo;

	public Locação() {

	}

	public Locação(Veículo modelo, LocalDateTime dataInicial, LocalDateTime dataFinal, Double valorPorHora, Double valorPorDia) {
		this.modelo = modelo;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.valorPorHora = valorPorHora;
		this.valorPorDia = valorPorDia;
	}

	public Veículo getModelo() {
		return modelo;
	}

	
	
	
	@SuppressWarnings("deprecation")
	public Double valorBase() {
		int dias = dataFinal.getDay() - dataInicial.getDay();
		int horas = dataFinal.getHours() - dataInicial.getHours();
		int minutos = dataFinal.getMinutes() - dataInicial.getMinutes();

		if(dias < 1 && horas <= 12 && minutos == 0) {
			return horas * valorPorHora;
		}
		else if(dias < 1 && horas < 12 && minutos > 0) {
			return (horas + 1) * valorPorHora;
		}
		else if(dias < 1 && horas == 12 && minutos > 0) {
			return valorPorDia;
		}
		else if(dias < 1 && horas > 12) {
			return valorPorDia;
		}
		else if(dias >= 1 && horas == 0 && minutos == 0) {
			return dias * valorPorDia;
		}
		else if(dias >= 1 && horas == 0 && minutos > 0) {
			return (dias + 1) * valorPorDia;
		}
		else {
			return (dias + 1) * valorPorDia;
		}
	}

	public Double taxa() {
		if (valorBase() <= 100.0) {
			return valorBase() * 0.2;
		} else {
			return valorBase() * 0.15;
		}
	}

	public Double valorTotal() {
		return taxa() + valorBase();
	}

}
