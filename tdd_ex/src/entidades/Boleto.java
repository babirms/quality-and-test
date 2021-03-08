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

	public Boleto() {}

	public String getCodigoBoleto() {
		return codigoBoleto;
	}

	public void setCodigoBoleto(String codigoBoleto) {
		this.codigoBoleto = codigoBoleto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	};
	
	

}
