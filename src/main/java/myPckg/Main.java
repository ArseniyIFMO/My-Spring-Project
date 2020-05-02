package myPckg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//To Disable security, but enable H2 console

@SpringBootApplication(scanBasePackages = "myPckg", exclude = { SecurityAutoConfiguration.class })

//To Enable security, but disable H2 console
//@SpringBootApplication(scanBasePackages = "myPckg")


public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
