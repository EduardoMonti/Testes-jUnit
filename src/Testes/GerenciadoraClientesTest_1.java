package Testes;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import entities.Cliente;
import entities.GerenciadoraClientes;


public class GerenciadoraClientesTest_1 {
	
	@Test
	public void testPesquisaCliente() {
		
		int idCliente_1 = 1;
		int idCliente_2 = 2;
		
		
		//Criando alguns clientes
		Cliente cliente01 = new Cliente(idCliente_1, "Carlos", 26, "carlosteste@gmail.com", true, 1);
		Cliente cliente02 = new Cliente(idCliente_2, "Eduardo", 30, "carlosteste2@gmail.com", true, 2);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		Cliente cliente = gerClientes.pesquisaCliente(idCliente_1);
		
		//Verificando se o id do cliente é 1 e se o e-mail corresponde ao mesmo id
		assertThat(cliente.getId(), is(idCliente_1));
		assertThat(cliente.getEmail(), is("carlosteste@gmail.com"));
		
	}

}
