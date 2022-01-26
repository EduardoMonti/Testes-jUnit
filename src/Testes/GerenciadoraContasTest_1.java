package testes;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import entities.ContaCorrente;
import entities.GerenciadoraContas;

public class GerenciadoraContasTest_1 {
	
	private GerenciadoraContas gerContas;
	 int idConta_01 = 1;
	 int idConta_02 = 2;
	
	
	@Test
	public void testTransfereValor() {
		
		//Montagem do cenário de teste
		
		ContaCorrente conta01 = new ContaCorrente(idConta_01, 200, true);
		ContaCorrente conta02 = new ContaCorrente(idConta_02, 0, true);
		
		//Criando lista e adicionando conta
		
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contasDoBanco);
		
		//Execução
		boolean sucesso = gerContas.transfereValor(idConta_01, 100, idConta_02);
		
		//Verificação
		assertTrue(sucesso);
		assertThat(conta02.getSaldo(), is(100.0));
		
		
		
		
	}
	
	
}
