package microservicios.app.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//FIXME Para evitar el error del datasource, (porque hereda jpa de las librerias)
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@EnableEurekaClient
@SpringBootApplication
public class MicroserviciosUsuariosApplication {

	public static void main(final String[] args) {
		SpringApplication.run(MicroserviciosUsuariosApplication.class, args);
	}

}
