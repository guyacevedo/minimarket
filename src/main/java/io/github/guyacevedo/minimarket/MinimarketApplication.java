package io.github.guyacevedo.minimarket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.guyacevedo.minimarket.persistence.service.InstalacionService;



@SpringBootApplication
public class MinimarketApplication implements CommandLineRunner {

	@Autowired
	@Qualifier("instalacionService")
	private InstalacionService instalacionService;

	private static final Log logger = LogFactory.getLog(MinimarketApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MinimarketApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Verificar si existen los usuarios iniciales
				try {
					instalacionService.init_usuarios();
				} catch (Exception e) {
					logger.info("Error al iniciar \n" + e);
				}
		
	}

}
