package miu.edu.jwtsecurity.lab6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityJwtApplication {

	    @Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(SecurityJwtApplication.class, args);
    }


}
