package br.com.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@Configuration
@ComponentScan("br.com.code")*/

@SpringBootApplication(scanBasePackages="br.com.code")
public class RootConfig {
	
	public static void main(String[] args) {
		SpringApplication.run(RootConfig.class, args);
	}

}
