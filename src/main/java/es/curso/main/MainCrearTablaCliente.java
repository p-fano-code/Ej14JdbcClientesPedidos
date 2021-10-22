package es.curso.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.curso.cnfg.Config;
import es.curso.modelo.persistencia.DaoClienteJdbcTemplate;

public class MainCrearTablaCliente {

	private static ApplicationContext context;
	
	static{
		context = new AnnotationConfigApplicationContext(Config.class);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaoClienteJdbcTemplate dao = context.getBean("daoClienteJdbcTemplate", DaoClienteJdbcTemplate.class);
		dao.crearTablaClientes();
		System.out.println("la tabla ha sido creada!!!");
		

	}

}
