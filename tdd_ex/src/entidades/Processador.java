package entidades;

import java.util.List;

import enums.StatusPagamento;


public class Processador {
	public List<Boleto> boletos;
	
	public Processador(List<Boleto> boletos) {
		super();
		this.boletos = boletos;
	}

	public Processador() {};
	
	public List<Pagamento> realizaPagamentoFatura(Fatura fatura, List<Boleto> boletos) {
		double valorPago = 0;
		for (Boleto boleto : boletos) {
			valorPago = valorPago + boleto.valorPago;
		}
		
		if(valorPago < fatura.valorTotal) {
			fatura.setStatus(StatusPagamento.NAO_PAGO);
		}
		else {
			fatura.setStatus(StatusPagamento.PAGO);
		}
		return null;
	}
	
	

}
