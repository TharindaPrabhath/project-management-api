package com.symetry.projectmanagementapi.user;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository){
        return args-> {
            User u1 = new User("Tharinda","Anurajeewa","tharindahp","qwerty",LocalDate.of(2021, 05, 23));
            User u2 = new User("Fav","One","feather","123",LocalDate.of(2021, 05, 20));
            userRepository.saveAll(List.of(u1, u2));
        };
    }
    
}
