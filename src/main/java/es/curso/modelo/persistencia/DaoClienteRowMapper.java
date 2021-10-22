package es.curso.modelo.persistencia;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import es.curso.modelo.entidades.Cliente;
import es.curso.modelo.entidades.Pedido;
@Component
public class DaoClienteRowMapper implements RowMapper<Cliente>{

	@Override
	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Cliente c = new Cliente();
		c.setId(rs.getInt("ID"));
		c.setEdad(rs.getInt("EDAD"));
		c.setListaPedidos((List<Pedido>) rs.getArray("LISTAPEDIDOS"));;
		return c;
	}

}
