package microservicios.app.contratos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients // FIXME necesario para habilitar el feign
@EnableEurekaClient
@SpringBootApplication
public class MicroserviciosContratosApplication {

	public static void main(final String[] args) {
		SpringApplication.run(MicroserviciosContratosApplication.class, args);
	}

}
