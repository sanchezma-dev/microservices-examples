package micro.usuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "micro.usuario.*" })
public class MsUsuariosApplication {

	public static void main(final String[] args) {
		SpringApplication.run(MsUsuariosApplication.class, args);
	}

}
