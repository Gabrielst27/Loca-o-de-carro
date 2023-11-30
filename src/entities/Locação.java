package entities;

import java.time.LocalDateTime;

public class Locação {
	
	private LocalDateTime início;
	private LocalDateTime fim;
	
	private Veículo veículo;
	private Fatura fatura;

	public Locação() {
		
	}

	public Locação(LocalDateTime início, LocalDateTime fim, Veículo veículo, Fatura fatura) {
		this.início = início;
		this.fim = fim;
		this.veículo = veículo;
		this.fatura = fatura;
	}

	public LocalDateTime getInício() {
		return início;
	}

	public void setInício(LocalDateTime início) {
		this.início = início;
	}

	public LocalDateTime getFim() {
		return fim;
	}

	public void setFim(LocalDateTime fim) {
		this.fim = fim;
	}

	public Veículo getVeículo() {
		return veículo;
	}

	public void setVeículo(Veículo veículo) {
		this.veículo = veículo;
	}

	public Fatura getFatura() {
		return fatura;
	}

	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}
	
	
	
}
