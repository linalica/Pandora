package by.itransition.pandora;

import by.itransition.pandora.configuration.DataConfiguration;
import by.itransition.pandora.configuration.SecurityConfiguration;
import by.itransition.pandora.configuration.WebConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({DataConfiguration.class, WebConfiguration.class, SecurityConfiguration.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /*@Bean
    CommandLineRunner bootstrap(final UserRepository userRepository, final PasswordEncoder passwordEncoder) {
        return (args) -> {
            userRepository.save(
                    new User("Peter", passwordEncoder.encode("password"), UserRole.ROLE_ADMIN)
            );

            userRepository.save(
                    new User("John", passwordEncoder.encode("password"), UserRole.ROLE_USER)
            );

            userRepository.findAll().stream().map(User::toString).forEach(System.out::println);
        };
    }*/

}





