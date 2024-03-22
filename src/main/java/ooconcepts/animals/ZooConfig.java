package ooconcepts.animals;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ZooConfig {

    @Bean
    public Zoo zoo() {
        return new Zoo(List.of(new Hippo("Fatty", "Grass", "River"), new Ibis(), new Wolf()));
    }
}
