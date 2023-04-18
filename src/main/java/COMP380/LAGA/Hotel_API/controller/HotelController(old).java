////package COMP380.LAGA.Hotel_API.controller;
////
////import COMP380.LAGA.Hotel_API.model.Customer;
////import COMP380.LAGA.Hotel_API.repository.HotelRepository;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.*;
////
////import java.util.List;
////import java.util.Optional;
////
////@RestController
////@RequestMapping("/api/customers")
////public class HotelController {
////
////    @Autowired
////    private HotelRepository hotelRepository;
////
////    @GetMapping
////    public List<Customer> getAllCustomers() {
////        return hotelRepository.findAll();
////    }
////
////    @GetMapping("/{email}")
////    public ResponseEntity<Customer> getCustomerByEmail(@PathVariable("email") String email) {
////        Optional<Customer> customer = hotelRepository.findById(email);
////
////        if (customer.isPresent()) {
////            return ResponseEntity.ok().body(customer.get());
////        } else {
////            return ResponseEntity.notFound().build();
////        }
////    }
////
////    @PostMapping
////    public Customer createCustomer(@RequestBody Customer customer) {
////        return hotelRepository.save(customer);
////    }
////
////    @PutMapping("/{email}")
////    public ResponseEntity<Customer> updateCustomer(@PathVariable("email") String email, @RequestBody Customer customerDetails) {
////        Optional<Customer> customer = hotelRepository.findById(email);
////
////        if (customer.isPresent()) {
////            Customer updatedCustomer = customer.get();
////            updatedCustomer.setName(customerDetails.getName());
////            updatedCustomer.setNumber(customerDetails.getNumber());
////            updatedCustomer.setAddress(customerDetails.getAddress());
////
////            return ResponseEntity.ok().body(hotelRepository.save(updatedCustomer));
////        } else {
////            return ResponseEntity.notFound().build();
////        }
////    }
////
////    @DeleteMapping("/{email}")
////    public ResponseEntity<Void> deleteCustomer(@PathVariable("email") String email) {
////        Optional<Customer> customer = hotelRepository.findById(email);
////
////        if (customer.isPresent()) {
////            hotelRepository.delete(customer.get());
////            return ResponseEntity.ok().build();
////        } else {
////            return ResponseEntity.notFound().build();
////        }
////    }
////}
//
//package COMP380.LAGA.Hotel_API.controller;
//
//import COMP380.LAGA.Hotel_API.model.*;
//import COMP380.LAGA.Hotel_API.repository.HotelRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api")
//public class HotelController {
//
//    @Autowired
//    private HotelRepository hotelRepository;
//
//    // Customer endpoints
//    @GetMapping("/customers")
//    public List<Customer> getAllCustomers() {
//        return hotelRepository.findAll(Customer.class);
//    }
//
//    @GetMapping("/customers/{email}")
//    public ResponseEntity<Customer> getCustomerByEmail(@PathVariable("email") String email) {
//        Optional<Customer> customer = hotelRepository.findById(email, Customer.class);
//
//        if (customer.isPresent()) {
//            return ResponseEntity.ok().body(customer.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PostMapping("/customers")
//    public Customer createCustomer(@RequestBody Customer customer) {
//        return hotelRepository.save(customer);
//    }
//
//    @PutMapping("/customers/{email}")
//    public ResponseEntity<Customer> updateCustomer(@PathVariable("email") String email, @RequestBody Customer customerDetails) {
//        Optional<Customer> customer = hotelRepository.findById(email, Customer.class);
//
//        if (customer.isPresent()) {
//            Customer updatedCustomer = customer.get();
//            updatedCustomer.setName(customerDetails.getName());
//            updatedCustomer.setNumber(customerDetails.getNumber());
//            updatedCustomer.setAddress(customerDetails.getAddress());
//
//            return ResponseEntity.ok().body(hotelRepository.save(updatedCustomer));
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/customers/{email}")
//    public ResponseEntity<Void> deleteCustomer(@PathVariable("email") String email) {
//        Optional<Customer> customer = hotelRepository.findById(email, Customer.class);
//
//        if (customer.isPresent()) {
//            hotelRepository.delete(customer.get());
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    // Employee endpoints
//    @GetMapping("/employees")
//    public List<Employee> getAllEmployees() {
//        return hotelRepository.findAll(Employee.class);
//    }
//
//    @GetMapping("/employees/{password}")
//    public ResponseEntity<Employee> getEmployeeByPassword(@PathVariable("password") String password) {
//        Optional<Employee> employee = hotelRepository.findById(password, Employee.class);
//
//        if (employee.isPresent()) {
//            return ResponseEntity.ok().body(employee.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PostMapping("/employees")
//    public Employee createEmployee(@RequestBody Employee employee) {
//        return hotelRepository.save(employee);
//    }
//
//    @PutMapping("/employees/{password}")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable("password") String password, @RequestBody Employee employeeDetails) {
//        Optional<Employee> employee = hotelRepository.findById(password, Employee.class);
//
//        if (employee.isPresent()) {
//            Employee updatedEmployee = employee.get();
//            updatedEmployee.setName(employeeDetails.getName());
//            updatedEmployee.setNumber(employeeDetails.getNumber());
//            updatedEmployee.setAddress(employeeDetails.getAddress());
//
//            return ResponseEntity.ok().body(hotelRepository.save(updatedEmployee));
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/employees/{password}")
//    public ResponseEntity<Void> deleteEmployee(@PathVariable("password") String password) {
//        Optional<Employee> employee = hotelRepository.findById(password, Employee.class);
//
//        if (employee.isPresent()) {
//            hotelRepository.delete(employee.get());
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    // Hotel endpoints
//    @GetMapping("/hotels")
//    public List<
