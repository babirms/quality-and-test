package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois números.")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@DisplayName("Testa a divisão entre dois números.")
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		Assertions.assertEquals(2, divisao);		
	}
	
	@DisplayName("Testa a divisão de um número por zero.")
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exceção não lançada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@DisplayName("Testa a divisão por zero com AssertThrows.")
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}
	
	@DisplayName("Testa a subtração entre dois números.")
	@Test
	public void testSubtracaoDoisNumeros() {
		int sub = calc.subtracao(4, 5);		
		Assertions.assertEquals(-1, sub);		
	}
	
	
	@DisplayName("Testa a multiplicação entre dois números.")
	@Test
	public void testMultiplicacaoDoisNumeros() {
		int mul = calc.multiplicacao(5, 5);
		Assertions.assertEquals(25, mul);
	}
	
	@DisplayName("Testa o somatório de 0 até um número.")
	@Test
	public void testMultiplicacaoPorZero() {
		int somatorio = calc.somatoria(5);
		Assertions.assertEquals(15, somatorio);
	}
	
	@DisplayName("Testa se um número é positivo.")
	@Test
	public void testEhPositivoTrue() {
		boolean positivo = calc.ehPositivo(5);
		Assertions.assertEquals(true, positivo);
	}
	
	@DisplayName("Testa se um número é negativo.")
	@Test
	public void testEhPositivoFalse() {
		boolean positivo = calc.ehPositivo(-5);
		Assertions.assertEquals(false, positivo);
	}
	
	@DisplayName("Testa se dois números são iguais.")
	@Test
	public void testComparaNumerosIguais() {
		int iguais = calc.compara(10,10);
		Assertions.assertEquals(0, iguais);
	}
	
	@DisplayName("Testa se a > b.")
	@Test
	public void testComparaAMaiorB() {
		int maior = calc.compara(100,50);
		Assertions.assertEquals(1, maior);
	}
	
	@DisplayName("Testa se a < b.")
	@Test
	public void testComparaAMenorB() {
		int menor = calc.compara(10,50);
		Assertions.assertEquals(-1, menor);
	}

}
