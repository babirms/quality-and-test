package entidades;

import java.util.List;


public class Processador {
	public List<Boleto> boletos;
	
	public Processador(List<Boleto> boletos) {
		super();
		this.boletos = boletos;
	}

	public Processador() {};
	
	public void realizaPagamentoFatura(Fatura fatura, List<Boleto> boletos) {
	}
	
	

}
