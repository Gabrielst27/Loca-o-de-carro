package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Locação {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	private String modelo;
	private Date dataInicial;
	private Date dataFinal;
	private Double valorPorHora;
	private Double valorPorDia;

	public Locação() {

	}

	public Locação(String modelo, Date dataInicial, Date dataFinal, Double valorPorHora, Double valorPorDia) {
		this.modelo = modelo;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.valorPorHora = valorPorHora;
		this.valorPorDia = valorPorDia;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Double getValorPorHora() {
		return valorPorHora;
	}

	public void setValorPorHora(Double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}

	public Double getValorPorDia() {
		return valorPorDia;
	}

	public void setValorPorDia(Double valorPorDia) {
		this.valorPorDia = valorPorDia;
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
