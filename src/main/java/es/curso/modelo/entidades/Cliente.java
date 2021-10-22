package es.curso.modelo.entidades;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Cliente {

	private int id;
	private int edad;
	private ArrayList<Pedido> listaPedidos;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public ArrayList<Pedido> getListaPedidos() {
		return listaPedidos;
	}
	public void setListaPedidos(List<Pedido> list) {
		this.listaPedidos = (ArrayList<Pedido>) list;
	}
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", edad=" + edad + ", listaPedidos=" + listaPedidos + "]";
	}
	
	
	
	
}
