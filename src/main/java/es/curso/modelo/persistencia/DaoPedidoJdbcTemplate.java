package es.curso.modelo.persistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.curso.modelo.entidades.Cliente;
import es.curso.modelo.entidades.Pedido;

@Repository
public class DaoPedidoJdbcTemplate implements DaoPedido{

	@Autowired
	private JdbcTemplate jtemplate;
	@Autowired
	private DaoPedidoRowMapper pedidoRowMapper;
	
	@Override
	public int addPedido(Pedido p) {
		// TODO Auto-generated method stub
		String query = "insert into pedidos (IMPORTE,FECHA) values (?,?,?)";
		int id = jtemplate.update(query,
				 p.getImporte(),
				 p.getFecha());
		return id;
	}

	@Override
	public int delPedido(int id) {
		// TODO Auto-generated method stub
		String query = "delte from pedidos where id = ?";
		return jtemplate.update(query,id);
	}

	@Override
	public int modPedido(Pedido p) {
		// TODO Auto-generated method stub
		String query = "update pedidos SET IMPORTE=?, FECHA=? where id=?";
		int id = jtemplate.update(query,
				p.getImporte(),
				p.getFecha(),
				p.getId()
			);
		return id;
	}

	@Override
	public Pedido searchPedido(int id) {
		// TODO Auto-generated method stub
		String query = "select * from pedidos where id=?";
		Pedido p = null;
		try {
			p = jtemplate.queryForObject(query, pedidoRowMapper, id);
		} catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
			System.out.println("EmptyResultDataAccessException: " + e.getMessage());
		}
		return p;
	}

	@Override
	public List<Pedido> listar() {
		// TODO Auto-generated method stub
		String query = "select * from pedidos";
		return jtemplate.query(query, pedidoRowMapper);
	}
	
	public void crearTablaPedidos() {
		jtemplate.execute("CREATE TABLE pedidos (" +
				"id int NOT NULL AUTO_INCREMENT," +
				"importe int," +
				"fecha date," +
				"PRIMARY KEY (id)" +
				"); ");
				
	}

}
