package gruppe.iso.ipu.server_spring.configuration;

import gruppe.iso.ipu.server_spring.model.Employee;
import gruppe.iso.ipu.server_spring.repository.EmployeeRepository;
import net.datafaker.Faker;
import net.datafaker.providers.base.Internet;
import net.datafaker.providers.base.Name;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LoadDatabase {

    private static Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDb(EmployeeRepository employeeRepository) {
        return args -> {
            Faker faker = new Faker();
            for (int i = 0; i < 500; i++) {
                Name nameFaker = faker.name();
                Internet internetFaker = faker.internet();
                Employee employee = new Employee();
                employee.setSalutation(nameFaker.prefix());
                employee.setFirstName(nameFaker.firstName());
                employee.setLastName(nameFaker.lastName());
                employee.setUsername(internetFaker.emailAddress());
                log.info("{}: Inserting employee {}", i, employee);
                employeeRepository.save(employee);
            }

        };
    }


}
