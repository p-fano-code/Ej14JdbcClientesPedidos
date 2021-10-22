package es.curso.modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.curso.modelo.entidades.Cliente;
import es.curso.modelo.entidades.Pedido;
import es.curso.modelo.persistencia.DaoCliente;
@Service
public class GestorCliente{

	@Autowired
	DaoCliente daoCliente;
	
	public int addCliente(Cliente c) {
		return daoCliente.addCliente(c);
	}
	public int delCliente(int id) {
		return daoCliente.delCliente(id);
	}
	public int modCliente(Cliente c) {
		return daoCliente.modCliente(c);
	}
	public Cliente searchCliente(int id) {
		return daoCliente.searchCliente(id);
	}
	public List<Cliente> listPedidoCliente(){
		return daoCliente.listPedidoCliente();
	}
	
	

}
