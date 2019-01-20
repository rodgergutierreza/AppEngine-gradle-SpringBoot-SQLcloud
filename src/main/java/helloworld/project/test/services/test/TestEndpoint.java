package helloworld.project.test.services.test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import helloworld.project.test.config.ConstantAttributes;
import helloworld.project.test.services.test.TestServices;;


@Component
@RestController
@RequestMapping("test")
public class TestEndpoint implements ConstantAttributes{
	
	@Autowired
	public TestServices testServices;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getTest() throws Exception {
		return this.generarRespuesta(this.testServices.getTest());
	}
	
	private ResponseEntity<Object> generarRespuesta(Object objeto) {
		HttpHeaders headers = new HttpHeaders();
		return ResponseEntity.accepted().headers(headers).body(objeto);
	}

}
