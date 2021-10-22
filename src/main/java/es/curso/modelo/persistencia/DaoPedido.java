package es.curso.modelo.persistencia;

import java.util.List;

import es.curso.modelo.entidades.Pedido;

public interface DaoPedido {

	int addPedido(Pedido p);
	int delPedido(int id);
	int modPedido(Pedido p);
	Pedido searchPedido(int id);
	List<Pedido> listar();
}
