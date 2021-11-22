package journal.Code.JournalAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class},
		      proxyBeanMethods = false)
public class JournalApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JournalApiApplication.class, args);
	}

}
