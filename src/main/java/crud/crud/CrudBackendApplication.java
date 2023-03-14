package crud.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudBackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrudBackendApplication.class, args);
		System.out.println("Servidor Rodando!");
	}

}
