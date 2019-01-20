package helloworld.project.test.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Handler {
	
	public boolean status;
	public String metodo;
	public String url;
	public String description;
	
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handle(Exception ex, HttpServletRequest request, HttpServletResponse response) {
    	
    	System.out.println("\n\n\tURL del error : " + request.getRequestURL() + "\n\tLa Exception es :  " + ex);
    	
        if (ex instanceof NullPointerException) {
        	System.out.println("\tExcepcion para datos no encontrados");
        	Handler nuevo = new Handler();
        	nuevo.status = false;
        	nuevo.metodo = request.getMethod().toString();
        	nuevo.url = request.getRequestURL().toString();
        	nuevo.description = "Dato no encontrado";
        	return ResponseEntity.status(HttpStatus.ACCEPTED).body(nuevo);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}