package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Classe para teste do Carrinho")
public class CarrinhoTest {
	

	private Carrinho carrinho;
	
	@BeforeEach
	public void inicializa() {
		carrinho = new Carrinho();
		carrinho.addItem(new Produto("Doce de Leite", 5.00));
	}
	
	@DisplayName("Testa o valor total dos itens do carrinho.")
	@Test
	public void testGetValorTotal() {
		carrinho.addItem(new Produto("Pão de Forma", 7.00));
		carrinho.addItem(new Produto("Leite", 2.00));
		carrinho.addItem(new Produto("Creme de Leite", 3.00));
		
		double valorFinal = carrinho.getValorTotal();
		assertEquals(17.00, valorFinal);
	}
	
	@DisplayName("Testa se um item é removido com sucesso do carrinho.")
	@Test
	public void testRemoveItemSucess()  throws ProdutoNaoEncontradoException{
		Produto removableItem = new Produto("Doce de Leite", 5.00);
		carrinho.removeItem(removableItem);
		assertEquals(0, carrinho.getQtdeItems());
	}
	
	@DisplayName("Testa a execução de Exception ao tentar remover um item não existente.")
	@Test
	public void testRemoveItemFailed()  throws ProdutoNaoEncontradoException{
		Produto removableItem = new Produto("Gelatina", 0.80);
		assertThrows(ProdutoNaoEncontradoException.class,
				() -> carrinho.removeItem(removableItem));	
	}
	
	
	@DisplayName("Testa a remoção de todos os itens de um carrinho.")
	@Test
	public void testEsvazia()  {
		carrinho.esvazia();
		assertEquals(0, carrinho.getQtdeItems());
		
	}
	
	

}
