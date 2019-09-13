package local.skylerwebdev.sprinttodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SprinttodoApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(SprinttodoApplication.class, args);
    }

}
