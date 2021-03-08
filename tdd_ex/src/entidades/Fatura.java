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

	public Fatura() {
	}

	public boolean isValida(Date data) {
		System.out.println(data.before(new Date()));
		if (data.before(new Date()) || data == new Date()) {
			return true;
		} else {
			return false;
		}
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public StatusPagamento getStatus() {
		return status;
	}

	public void setStatus(StatusPagamento status) {
		this.status = status;
	};

}
