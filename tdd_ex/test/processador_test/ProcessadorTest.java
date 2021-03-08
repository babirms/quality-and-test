package processador_test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import entidades.Boleto;
import entidades.Fatura;
import entidades.Processador;
import enums.StatusPagamento;

public class ProcessadorTest {


	@Test
	@DisplayName("1 - Verifica o status de pagamento de uma fatura que já foi paga.")
	void verificaFaturaPaga() {

		// Cria fatura
		Fatura fatura = new Fatura(new Date(), 2000, "Sérgio Fontes" );
		// Cria boletos da fatura
		Boleto b1 = new Boleto("1", new Date(), 500);
		Boleto b2 = new Boleto("2", new Date(), 1500);
		List<Boleto> boletos = new ArrayList<Boleto>();
		boletos.add(b1);
		boletos.add(b2);
		// Inicializa processador
		Processador processador = new Processador(boletos);
		// processa o pagamento dos boletos
		processador.realizaPagamentoFatura(fatura, boletos);
				
		Assertions.assertEquals(fatura.getStatus(), StatusPagamento.PAGO);

	}
	
	@Test
	@DisplayName("2 - Verifica o status de pagamento de uma fatura que não foi paga.")
	void verificaFaturaNaoPaga() {
		// Cria fatura
		Fatura fatura = new Fatura(new Date(), 2000, "Luciana Lopes" );
		// Cria boletos da fatura
		Boleto b1 = new Boleto("1", new Date(), 500);
		List<Boleto> boletos = new ArrayList<Boleto>();
		boletos.add(b1);
		// Inicializa processador
		Processador processador = new Processador(boletos);
		
		// processa o pagamento dos boletos
		processador.realizaPagamentoFatura(fatura, boletos);
						
		Assertions.assertEquals(fatura.getStatus(), StatusPagamento.NAO_PAGO);

	}
	
	@Test
	@DisplayName("3 - Verifica se o valor de um boleto foi pago integralmente")
	void verificaBoletoPagoIntegralmente() {

	}
	
	@Test
	@DisplayName(" 4 - Verifica se o valor de um boleto não foi pago integralmente")
	void verificaBoletoNaoPagoIntegralmente() {

	}
	
	@Test
	@DisplayName("5 - Verifica se o pagamento de um boleto é válido a partir da sua data de validade")
	void verificaBoletoValido() {

	}
	
	@Test
	@DisplayName("6 - Verifica se o pagamento de um boleto não é válido a partir da sua data de validade")
	void verificaBoletoInvalido() {

	}
}
