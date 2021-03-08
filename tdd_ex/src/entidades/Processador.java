package entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enums.StatusPagamento;
import enums.TipoPagamento;

public class Processador {
	public List<Boleto> boletos;

	public Processador(List<Boleto> boletos) {
		super();
		this.boletos = boletos;
	}

	public Processador() {
	};

	public List<Pagamento> realizaPagamentoFatura(Fatura fatura, List<Boleto> boletos) {
		double valorPago = 0;
		List<Pagamento> boletosPagos = new ArrayList<Pagamento>();
		for (Boleto boleto : boletos) {
			valorPago = valorPago + boleto.getValorPago();
			Pagamento boletoPago = new Pagamento(boleto.getValorPago(), new Date(), TipoPagamento.BOLETO);
			boletosPagos.add(boletoPago);
		}

		if (valorPago < fatura.valorTotal) {
			fatura.setStatus(StatusPagamento.NAO_PAGO);
		} else {
			fatura.setStatus(StatusPagamento.PAGO);
		}
		return boletosPagos;
	}

}
