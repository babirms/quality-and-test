package produto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProdutoTest {
	
	Produto livro;
	
	@BeforeEach
	public void inicializa() {
		livro = new Produto("Introdu��o ao Teste de Software", 100.00);
	}
	
	@DisplayName("Testa a cria��o de um produto.")
	@Test
	public void testCriaProduto() {
		Assertions.assertAll("livro",
				() -> assertEquals("Introdu��o ao Teste de Software", livro.getNome()),
				() -> assertEquals(100.00,livro.getPreco())						
				);
	}
	
	@DisplayName("Testa se dois livros s�o iguais.")
	@Test
	public void testProdutosIguais() {
		Produto livro2 = new Produto("Introdu��o ao Teste de Software", 90.00);
		
		assertNotSame(livro, livro2);
		
	}
	
	@DisplayName("Testa a altera��o de nome de um produto pr�-definido.")
	@Test
	public void testSetNome() {
		String newNome = "Qualidade e Teste - Vol I";
		livro.setNome(newNome);
		
		assertEquals(livro.getNome(), newNome);
					
	}
	
	@DisplayName("Testa a altera��o de pre�o de um produto pr�-definido.")
	@Test
	public void testSetPreco() {
		double newPreco = 85.50;
		livro.setPreco(newPreco);
		
		assertEquals(livro.getPreco(), newPreco);
					
	}
	
	@DisplayName("Testa se dois produtos s�o iguais.")
	@Test
	public void testEqualsTrue() {
		Produto livro3 = new Produto("Introdu��o ao Teste de Software", 100.00);
		boolean iguais = livro.equals(livro3);
		assertTrue(iguais);			
	}
	
	@DisplayName("Testa se dois produtos s�o diferentes.")
	@Test
	public void testEqualsFalse() {
		Produto livro3 = new Produto("Harry Potter e a Pedra Filosofal", 80.00);
		boolean iguais = livro.equals(livro3);
		assertFalse(iguais);			
	}
}
