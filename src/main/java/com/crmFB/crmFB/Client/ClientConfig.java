package com.crmFB.crmFB.Client;

import com.crmFB.crmFB.Province.Province;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ClientConfig {

    @Bean
    CommandLineRunner commandLineRunner(ClientRepository clientRepository){
        return args -> {
            Province Tuxtla = new Province(
                    "Tuxtla",
                    true
            );
            Province Bochil = new Province(
                    "Bochil",
                    true
            );

            Client miguel = new Client(
                    "Miguel",
                    Tuxtla,
                    9612111258L,
                    "angel-mma@hotmail.com",
                    500000,
                    "Interesado",
                    true
            );
            Client mario = new Client(
                    "Mario",
                    Bochil,
                    9612111258L,
                    "mario-dam@hotmail.com",
                    800000,
                    "Interesado",
                    true
            );
            clientRepository.saveAll(List.of(miguel,mario));
        };
    }
}
