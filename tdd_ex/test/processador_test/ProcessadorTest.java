package processador_test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import entidades.Boleto;
import entidades.Fatura;
import entidades.Pagamento;
import entidades.Processador;
import enums.StatusPagamento;

public class ProcessadorTest {

	@Test
	@DisplayName("1 - Verifica o status de pagamento de uma fatura que foi paga integralmente.")
	void verificaFaturaPaga() {
		// Cria fatura
		Fatura fatura = new Fatura(new Date(), 2000, "S�rgio Fontes");
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
	@DisplayName("2 - Verifica o status de pagamento de uma fatura que foi paga com valor superior.")
	void verificaFaturaPagaAMais() {
		// Cria fatura
		Fatura fatura = new Fatura(new Date(), 1200, "Natalia Souza");
		// Cria boletos da fatura
		Boleto b1 = new Boleto("1", new Date(), 800);
		Boleto b2 = new Boleto("2", new Date(), 200);
		Boleto b3 = new Boleto("2", new Date(), 300);
		List<Boleto> boletos = new ArrayList<Boleto>();
		boletos.add(b1);
		boletos.add(b2);
		boletos.add(b3);
		// Inicializa processador
		Processador processador = new Processador(boletos);
		// processa o pagamento dos boletos
		processador.realizaPagamentoFatura(fatura, boletos);

		Assertions.assertEquals(fatura.getStatus(), StatusPagamento.PAGO);

	}

	@Test
	@DisplayName("3 - Verifica o status de pagamento de uma fatura que n�o foi paga.")
	void verificaFaturaNaoPaga() {
		// Cria fatura
		Fatura fatura = new Fatura(new Date(), 2000, "Luciana Lopes");
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
	@DisplayName("4 - Verifica se o pagamento de uma Fatura � v�lido a partir da sua data de validade")
	void verificaFaturaValida() {
		// Cria fatura
		Fatura fatura = new Fatura(new Date(), 500, "Fernando Torres");
		// verifica se a fatura ainda est� no prazo de validade para pagamento
		boolean isValida = fatura.isValida(fatura.getData());

		Assertions.assertEquals(true, isValida);
	}

	@Test
	@DisplayName("5 - Verifica se o pagamento de uma Fatura n�o � v�lido a partir da sua data de validade")
	void verificaFaturaInvalida() {
		// Cria fatura
		Fatura fatura = new Fatura(new Date(2005, 4, 7), 500, "Fernando Torres");
		// verifica se a fatura ainda est� no prazo de validade para pagamento
		boolean isValida = fatura.isValida(fatura.getData());

		Assertions.assertEquals(false, isValida);
	}

	@Test
	@DisplayName("6 - Verifica se um Pagamento foi criado ao realizar pagamento")
	void criaUmPagamento() {
		// Cria fatura
		Fatura fatura = new Fatura(new Date(), 500, "Maria Fernanda");
		// Cria boletos da fatura
		Boleto b1 = new Boleto("1", new Date(), 500);
		List<Boleto> boletos = new ArrayList<Boleto>();
		boletos.add(b1);
		// Inicializa processador
		Processador processador = new Processador(boletos);
		// processa o pagamento dos boletos e retorna uma lista com os Pagamentos
		// criados
		List<Pagamento> pagamentos = processador.realizaPagamentoFatura(fatura, boletos);

		Assertions.assertEquals(pagamentos.size(), 1);

	}

	@Test
	@DisplayName("7 - Verifica se mais de um Pagamento foi criado ao realizar pagamento")
	void criaMaisPagamentos() {
		// Cria fatura
		Fatura fatura = new Fatura(new Date(), 4000, "Jos� Carlos");
		// Cria boletos da fatura
		Boleto b1 = new Boleto("1", new Date(), 500);
		Boleto b2 = new Boleto("2", new Date(), 1500);
		Boleto b3 = new Boleto("2", new Date(), 1000);
		List<Boleto> boletos = new ArrayList<Boleto>();
		boletos.add(b1);
		boletos.add(b2);
		boletos.add(b3);
		// Inicializa processador
		Processador processador = new Processador(boletos);
		// processa o pagamento dos boletos e retorna uma lista com os Pagamentos
		// criados
		List<Pagamento> pagamentos = processador.realizaPagamentoFatura(fatura, boletos);

		Assertions.assertEquals(pagamentos.size(), 3);

	}

	@Test
	@DisplayName("8 - Verifica se nenhum Pagamento foi criado ao realizar pagamento")
	void naoCriaPagamentos() {
		// Cria fatura
		Fatura fatura = new Fatura(new Date(), 200, "Arlindo Fernandes");
		// Cria lista vazia de boleto
		List<Boleto> boletos = new ArrayList<Boleto>();
		// Inicializa processador
		Processador processador = new Processador(boletos);
		// processa o pagamento dos boletos e retorna uma lista com os Pagamentos
		// criados
		List<Pagamento> pagamentos = processador.realizaPagamentoFatura(fatura, boletos);

		Assertions.assertEquals(pagamentos.size(), 0);
	}

	@Test
	@DisplayName("9 - Verifica status de uma fatura n�o paga e quantidade de pagamentos criados")
	void verificaPagamentosFaturaNaoPaga() {
		// Cria fatura
		Fatura fatura = new Fatura(new Date(), 2000, "Felipe Carvalho");
		// Cria boletos da fatura
		Boleto b1 = new Boleto("1", new Date(), 500);
		Boleto b2 = new Boleto("2", new Date(), 400);
		List<Boleto> boletos = new ArrayList<Boleto>();
		boletos.add(b1);
		boletos.add(b2);
		// Inicializa processador
		Processador processador = new Processador(boletos);
		// processa o pagamento dos boletos e retorna uma lista com os Pagamentos criados
		List<Pagamento> pagamentos = processador.realizaPagamentoFatura(fatura, boletos);

		Assertions.assertEquals(pagamentos.size(), 2);
		Assertions.assertEquals(fatura.getStatus(), StatusPagamento.NAO_PAGO);
	}

}
