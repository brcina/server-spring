package gruppe.iso.ipu.server_spring.repository;

import gruppe.iso.ipu.server_spring.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
