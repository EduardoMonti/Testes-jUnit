package testes;


import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import entities.Cliente;
import entities.GerenciadoraClientes;
import static org.junit.Assert.*;

public class GerenciadoraClientesTest_2 {
	
	private GerenciadoraClientes gerCliente;
	
	
	@Test
	public void testPesquisaCliente() {
		
		int idCliente_1 = 1;
		int idCliente_2 = 2;
	
		//Criando alguns clientes
	 	Cliente cliente01 = new Cliente(idCliente_1, "Carlos", 26, "carlosteste@gmail.com", true, 1);
		Cliente cliente02 = new Cliente(idCliente_2, "Eduardo", 30, "carlosteste2@gmail.com", true, 2);
		
		
		//Inserindo clientes na lista de clientes
		List <Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		
		gerCliente = new GerenciadoraClientes(clientesDoBanco);
		
		Cliente cliente = gerCliente.pesquisaCliente(idCliente_1);
		
		//Verificação
		assertThat(cliente.getId(), is(idCliente_1));
		
	}
	
		@Test
		public void testRemoveCliente() {
			
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
			
			boolean clienteRemovido = gerClientes.removeCliente(idCliente_2);
			
			//Verificações
			assertThat(clienteRemovido, is(true));
			assertThat(gerClientes.getClienteDoBanco().size(), is(idCliente_1));
			
			
			
		
		}

}
