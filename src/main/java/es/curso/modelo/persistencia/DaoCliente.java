package es.curso.modelo.persistencia;

import java.util.ArrayList;
import java.util.List;

import es.curso.modelo.entidades.Cliente;
import es.curso.modelo.entidades.Pedido;

public interface DaoCliente {

	int addCliente(Cliente c);
	int delCliente(int id);
	int modCliente(Cliente c);
	Cliente searchCliente(int id);
	void addPedidoCliente(int id);
	List<Cliente> listPedidoCliente();
}
