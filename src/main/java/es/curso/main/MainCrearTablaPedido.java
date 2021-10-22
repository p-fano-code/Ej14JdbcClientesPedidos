package es.curso.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.curso.cnfg.Config;
import es.curso.modelo.persistencia.DaoPedidoJdbcTemplate;

public class MainCrearTablaPedido {

private static ApplicationContext context;
	
	static{
		context = new AnnotationConfigApplicationContext(Config.class);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaoPedidoJdbcTemplate dao = context.getBean("daoPedidoJdbcTemplate", DaoPedidoJdbcTemplate.class);
		dao.crearTablaPedidos();
		System.out.println("la tabla ha sido creada!!!");
		

	}

}
