package es.curso.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.curso.modelo.entidades.Pedido;
import es.curso.modelo.persistencia.DaoPedido;
@Service
public class GestorPedido {

	@Autowired
	DaoPedido daoPedido;
	
	public int addPedido(Pedido p) {
		return daoPedido.addPedido(p);
	}
	public int delPedido(int id) {
		return daoPedido.delPedido(id);
	}
	public int modPedido(Pedido p) {
		return daoPedido.modPedido(p);
	}
	public Pedido searchPedido(int id) {
		return daoPedido.searchPedido(id);
	}
	public List<Pedido> listar(){
		return daoPedido.listar();
	}
	


}
