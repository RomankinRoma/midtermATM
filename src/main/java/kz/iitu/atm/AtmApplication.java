package kz.iitu.atm;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import kz.iitu.atm.swagger.CustomConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class AtmApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtmApplication.class, args);
    }
    @Autowired
    ObjectMapper ojectMapper;

    @PostConstruct
    void init() {
        CustomConverter.add(ojectMapper);
    }

    @Bean
    public OpenAPI customOpenAPI(@Value("Project for EAD") String appDesciption, @Value("1.0") String appVersion) {

        return new OpenAPI()
                .info(new Info()
                        .title("Banking System API")
                        .version(appVersion)
                        .description(appDesciption)
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("ATM A.R.A").url("https://iitu.kz")));
    }
}
