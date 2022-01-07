package za.co.sfy.lucid.sams.repository;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"za.co.sfy.lucid.sams.repository"})
@EntityScan({"za.co.sfy.lucid.sams.domain"})
@EnableJpaRepositories({"za.co.sfy.lucid.sams.repository"})
@EnableAutoConfiguration
@SpringBootConfiguration
public class RepositoriesTestConfiguration {
}
