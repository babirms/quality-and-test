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
	@DisplayName("1 - Verifica o status de pagamento de uma fatura que foi paga integralmente.")
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
	@DisplayName("3 - Verifica se o pagamento de uma Fatura é válido a partir da sua data de validade")
	void verificaFaturaValida() {
		// Cria fatura
		Fatura fatura = new Fatura(new Date(2021,4,7) ,500, "Fernando Torres" );
		// verifica se a fatura ainda está no prazo de validade para pagamento
		boolean isValida = fatura.isValida();
		
		Assertions.assertEquals(true, isValida);
	}
	
	@Test
	@DisplayName("3 - Verifica se o pagamento de uma Fatura não é válido a partir da sua data de validade")
	void verificaFaturaInvalida() {
		// Cria fatura
		Fatura fatura = new Fatura(new Date(2021,4,7) ,500, "Fernando Torres" );
		// verifica se a fatura ainda está no prazo de validade para pagamento
		boolean isValida = fatura.isValida();
		
		Assertions.assertEquals(false, isValida);
	}
	
	@Test
	@DisplayName("4 - Verifica se um Pagamento foi criado ao realizar pagamento")
	void criaUmPagamento() {

	}
	
	@Test
	@DisplayName("5 - Verifica se mais de um Pagamento foi criado ao realizar pagamento")
	void criaMaisPagamentos() {

	}
	
	@Test
	@DisplayName("6 - Verifica se nenhum Pagamento foi criado ao realizar pagamento")
	void naoCriaPagamentos() {

	}
}
