package microservicios.app.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//Anotación para habilitar Eureka, cuando arrancamos la apliacación
@EnableEurekaServer
@SpringBootApplication
public class MicroserviciosEurekaApplication {

	public static void main(final String[] args) {
		SpringApplication.run(MicroserviciosEurekaApplication.class, args);
	}

}
