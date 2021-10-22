package es.curso.modelo.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import es.curso.modelo.entidades.Pedido;

@Component
public class DaoPedidoRowMapper implements RowMapper<Pedido>{

	@Override
	public Pedido mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Pedido p = new Pedido();
		p.setId(rs.getInt("ID"));
		p.setFecha(rs.getDate("FECHA"));
		p.setImporte(rs.getDouble("IMPORTE"));
		return p;
	}

}
