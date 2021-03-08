package entidades;

import java.util.Date;

import enums.StatusPagamento;

public class Fatura {
	public Date data;
	public double valorTotal;
	public String nomeCliente;
	public StatusPagamento status;
	
	public Fatura(Date data, double valorTotal, String nomeCliente) {
		super();
		this.data = data;
		this.valorTotal = valorTotal;
		this.nomeCliente = nomeCliente;
	}

	public Fatura() {};
	
	

}
