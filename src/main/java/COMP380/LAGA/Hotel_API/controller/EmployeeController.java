package COMP380.LAGA.Hotel_API.controller;

import COMP380.LAGA.Hotel_API.model.Employee;
import COMP380.LAGA.Hotel_API.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * The EmployeeController class represents a RESTful API controller for handling employee-related requests.
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Retrieves a list of all employees from the employee repository.
     *
     * @return A ResponseEntity containing the list of employees and an HTTP status code indicating the success of the operation.
     */
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    /**
     * Retrieves a specific employee from the employee repository based on their ID.
     *
     * @param id The ID of the employee to retrieve.
     * @return A ResponseEntity containing the employee and an HTTP status code indicating the success of the operation.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") String id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Adds a new employee to the employee repository.
     *
     * @param employee The employee object to be added.
     * @return A ResponseEntity containing the created employee and an HTTP status code indicating the success of the operation.
     */
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeRepository.save(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    /**
     * Updates an existing employee in the employee repository based on their ID.
     *
     * @param id The ID of the employee to update.
     * @param employee The updated employee object.
     * @return A ResponseEntity containing the updated employee and an HTTP status code indicating the success of the operation.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") String id, @RequestBody Employee employee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        if (existingEmployee.isPresent()) {
            Employee updatedEmployee = existingEmployee.get();
            updatedEmployee.setEmail(employee.getEmail());
            updatedEmployee.setName(employee.getName());
            updatedEmployee.setNumber(employee.getNumber());
            updatedEmployee.setAddress(employee.getAddress());
            employeeRepository.save(updatedEmployee);
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Deletes an existing employee from the employee repository based on their ID.
     *
     * @param id The ID of the employee to delete.
     * @return A ResponseEntity with no content and an HTTP status code indicating the success of the operation.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") String id) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        if (existingEmployee.isPresent()) {
            employeeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
