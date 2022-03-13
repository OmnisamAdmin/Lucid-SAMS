package za.co.sfy.lucid.sams.resource;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"za.co.sfy.lucid.sams.resource"})
@EntityScan({"za.co.sfy.lucid.sams.domain"})
@EnableAutoConfiguration
@SpringBootConfiguration
public class RecourceTestConfiguration {
}