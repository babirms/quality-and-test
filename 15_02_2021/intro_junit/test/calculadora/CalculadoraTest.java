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
	
	@DisplayName("Testa a soma de dois n�meros.")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@DisplayName("Testa a divis�o entre dois n�meros.")
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		Assertions.assertEquals(2, divisao);		
	}
	
	@DisplayName("Testa a divis�o de um n�mero por zero.")
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exce��o n�o lan�ada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@DisplayName("Testa a divis�o por zero com AssertThrows.")
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}
	
	@DisplayName("Testa a subtra��o entre dois n�meros.")
	@Test
	public void testSubtracaoDoisNumeros() {
		int sub = calc.subtracao(4, 5);		
		Assertions.assertEquals(-1, sub);		
	}
	
	
	@DisplayName("Testa a multiplica��o entre dois n�meros.")
	@Test
	public void testMultiplicacaoDoisNumeros() {
		int mul = calc.multiplicacao(5, 5);
		Assertions.assertEquals(25, mul);
	}
	
	@DisplayName("Testa o somat�rio de 0 at� um n�mero.")
	@Test
	public void testMultiplicacaoPorZero() {
		int somatorio = calc.somatoria(5);
		Assertions.assertEquals(15, somatorio);
	}
	
	@DisplayName("Testa se um n�mero � positivo.")
	@Test
	public void testEhPositivoTrue() {
		boolean positivo = calc.ehPositivo(5);
		Assertions.assertEquals(true, positivo);
	}
	
	@DisplayName("Testa se um n�mero � negativo.")
	@Test
	public void testEhPositivoFalse() {
		boolean positivo = calc.ehPositivo(-5);
		Assertions.assertEquals(false, positivo);
	}
	
	@DisplayName("Testa se dois n�meros s�o iguais.")
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
