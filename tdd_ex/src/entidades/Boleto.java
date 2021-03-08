package entidades;

import java.util.Date;

public class Boleto {
	public String codigoBoleto;
	public Date data;
	public double valorPago;
	
	public Boleto(String codigoBoleto, Date data, double valorPago) {
		super();
		this.codigoBoleto = codigoBoleto;
		this.data = data;
		this.valorPago = valorPago;
	}

	public Boleto() {};

}
