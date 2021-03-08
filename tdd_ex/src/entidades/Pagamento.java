package entidades;

import java.util.Date;

import enums.TipoPagamento;

public class Pagamento {
	public double valorPago;
	public Date data;
	public TipoPagamento tipoPagamento;
	
	public Pagamento(double valorPago, Date data, TipoPagamento tipoPagamento) {
		super();
		this.valorPago = valorPago;
		this.data = data;
		this.tipoPagamento = tipoPagamento;
	}
	
	public Pagamento() {
	}

}
