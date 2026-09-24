package com.learningspringboot.student.student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Configuration
public class studentsConfig {
    @Bean
    CommandLineRunner commandLineRunner(studentsRepository repository){
        return args -> {
            if (repository.count()==0) {
                students rishi = new students(

                        "rishi",
                        "rishi@gmail.com",
                        LocalDate.of(2000, Month.JANUARY, 5)

                );
                students rishav = new students(

                        "rishav",
                        "rishav@gmail.com",
                        LocalDate.of(2004, Month.JANUARY, 18)

                );
                repository.saveAll(
                        List.of(rishi, rishav)
                );

            }

        };
    }


}