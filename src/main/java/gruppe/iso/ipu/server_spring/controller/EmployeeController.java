package gruppe.iso.ipu.server_spring.controller;

import gruppe.iso.ipu.server_spring.exception.EmployeeNotFoundException;
import gruppe.iso.ipu.server_spring.model.Employee;
import gruppe.iso.ipu.server_spring.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/employees")
    public List<Employee> all() {
        return repository.findAll();
    }

    @PostMapping("/employees")
    public Employee newEmployee(Employee newEmployee) {
        return repository.save(newEmployee);
    }

    @GetMapping("/employees/{id}")
    public Employee one(@PathVariable  Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PutMapping("/employees/{id}")
    public Employee replaceEmployee(Employee newEmployee, @PathVariable  Long id) {
        return repository.findById(id)
                .map(employee -> {
                    employee.setSalutation(newEmployee.getSalutation());
                    employee.setFirstName(newEmployee.getFirstName());
                    employee.setLastName(newEmployee.getLastName());
                    employee.setNotes(newEmployee.getNotes());
                    return repository.save(employee);
                })
                .orElseGet(() -> repository.save(newEmployee));

    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
