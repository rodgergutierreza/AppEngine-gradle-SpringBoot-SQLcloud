package helloworld.project;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Component
@RestController
@RequestMapping("/")
public class ProjectApplication {

	@Value("${spring.cloud.gcp.project-id}")
	private String environment;

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String holamundo() {
		String body = "<br><br> <CENTER><h1>HOLA MUNDO</h1><br><h3>" + "PROYECTO: " +environment+ "</h3>"
				+"<br><h3>TEST SQL CLOUD: <a href='test'>testear</a></h3></CENTER>";
		return body;
	}
}
