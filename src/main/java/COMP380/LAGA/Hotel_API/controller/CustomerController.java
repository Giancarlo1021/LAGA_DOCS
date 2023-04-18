package COMP380.LAGA.Hotel_API.controller;

import COMP380.LAGA.Hotel_API.model.Customer;
import COMP380.LAGA.Hotel_API.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * The CustomerController class represents a RESTful API controller for handling customer-related requests.
 */
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Retrieves a list of all customers from the customer repository.
     *
     * @return A ResponseEntity containing the list of customers and an HTTP status code indicating the success of the operation.
     */
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    /**
     * Retrieves a specific customer from the customer repository based on their email address.
     *
     * @param email The email address of the customer to retrieve.
     * @return A ResponseEntity containing the customer and an HTTP status code indicating the success of the operation.
     */
    @GetMapping("/{email}")
    public ResponseEntity<Customer> getCustomerByEmail(@PathVariable("email") String email) {
        Optional<Customer> customer = customerRepository.findById(email);
        return customer.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Adds a new customer to the customer repository.
     *
     * @param customer The customer object to be added.
     * @return A ResponseEntity containing the created customer and an HTTP status code indicating the success of the operation.
     */
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerRepository.save(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    /**
     * Updates an existing customer in the customer repository based on their email address.
     *
     * @param email The email address of the customer to update.
     * @param customer The updated customer object.
     * @return A ResponseEntity containing the updated customer and an HTTP status code indicating the success of the operation.
     */
    @PutMapping("/{email}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("email") String email, @RequestBody Customer customer) {
        Optional<Customer> existingCustomer = customerRepository.findById(email);
        if (existingCustomer.isPresent()) {
            Customer updatedCustomer = existingCustomer.get();
            updatedCustomer.setName(customer.getName());
            updatedCustomer.setNumber(customer.getNumber());
            updatedCustomer.setAddress(customer.getAddress());
            customerRepository.save(updatedCustomer);
            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Deletes an existing customer from the customer repository based on their email address.
     *
     * @param email The email address of the customer to delete.
     * @return A ResponseEntity with no content and an HTTP status code indicating the success of the operation.
     */
    @DeleteMapping("/{email}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("email") String email) {
        Optional<Customer> existingCustomer = customerRepository.findById(email);
        if (existingCustomer.isPresent()) {
            customerRepository.deleteById(email);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
