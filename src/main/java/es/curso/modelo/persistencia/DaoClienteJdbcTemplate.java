package es.curso.modelo.persistencia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.curso.modelo.entidades.Cliente;
import es.curso.modelo.entidades.Pedido;

@Repository
public class DaoClienteJdbcTemplate implements DaoCliente{

	@Autowired
	private JdbcTemplate jtemplate;
	
	@Autowired
	private DaoClienteRowMapper clienteRowMapper;
	
	
	@Override
	public int addCliente(Cliente c) {
		// TODO Auto-generated method stub
		String query = "insert into clientes (EDAD,LISTAPEDIDOS) values (?,?)";
		int id = jtemplate.update(query,
				c.getEdad(),
				c.getListaPedidos()
			);
		return id;
	}

	@Override
	public int delCliente(int id) {
		// TODO Auto-generated method stub
		String query = "delte from clientes where id = ?";
		return jtemplate.update(query,id);
	}

	@Override
	public int modCliente(Cliente c) {
		// TODO Auto-generated method stub
		String query = "update clientes SET EDAD=?, LISTAPEDIDOS=? where id=?";
		int id = jtemplate.update(query,
				c.getEdad(),
				c.getListaPedidos(),
				c.getId()
			);
		return id;
	}

	@Override
	public Cliente searchCliente(int id) {
		// TODO Auto-generated method stub
		String query = "select * from clientes where id=?";
		Cliente cli = null;
		try {
			cli = jtemplate.queryForObject(query, clienteRowMapper, id);
		} catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
			System.out.println("EmptyResultDataAccessException: " + e.getMessage());
		}
		return cli;
	}

	@Override
	public void addPedidoCliente(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cliente> listPedidoCliente() {
		// TODO Auto-generated method stub
		String query = "select * from clientes";
		return jtemplate.query(query, clienteRowMapper);
	}
	
	public void crearTablaClientes() {
		jtemplate.execute("CREATE TABLE clientes (" +
				"id int NOT NULL AUTO_INCREMENT," +
				"edad int," +
				"id_pedido int," +
				"PRIMARY KEY (id)," +
				"FOREIGN KEY (id_pedido) REFERENCES pedidos(id)" +
				"); ");
				
	}

}
