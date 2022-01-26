package testes;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Cliente;
import entities.GerenciadoraClientes;

//Utilizando @before e @after para ganhar tempo e otimizar testes com cenários parecidos

public class GerenciadoraClienteTest_3 {
	
	
	private GerenciadoraClientes gerClientes;
	int idCliente_1 = 1;
	int idCliente_2 = 2;
	
	@Before
	public void Setup() {
		
		//Montagem do cenário de teste
		
		//Criando clientes
		Cliente cliente01 = new Cliente(idCliente_1, "Carlos", 26, "carlosteste@gmail.com", true, 1);
		Cliente cliente02 = new Cliente(idCliente_2, "Eduardo", 30, "carlosteste2@gmail.com", true, 2);
		
		
		// Criando e inserido clientes na lista
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
	}
	
	
	@After
	public void tearDown() {
		gerClientes.limpa();
	}
	
	@Test
	public void TestPesquisaCliente() {
		
		//Execução
		Cliente cliente = gerClientes.pesquisaCliente(idCliente_1);
		
		//Verificação
		assertThat(cliente.getId(), is(idCliente_1));
		
	}
	
	
	@Test
	public void TestRemoveCliente() {
		
		//Execução
		boolean clienteRemovido = gerClientes.removeCliente(idCliente_2);
		
		//Verificação
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClienteDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(idCliente_2));
	}
	

}
