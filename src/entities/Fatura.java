package entities;

public class Fatura {
	
	private Double valorBase;
	private Double taxa;
	
	public Fatura() {
		
	}

	public Fatura(Double valorBase, Double taxa) {
		this.valorBase = valorBase;
		this.taxa = taxa;
	}

	public Double getValorBase() {
		return valorBase;
	}

	public void setValorBase(Double valorBase) {
		this.valorBase = valorBase;
	}

	public Double getTaxa() {
		return taxa;
	}

	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}
	
	public Double getValorTotal() {
		return getValorBase() - getTaxa();
	}

}
