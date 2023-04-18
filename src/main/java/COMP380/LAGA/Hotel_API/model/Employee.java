package COMP380.LAGA.Hotel_API.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Employee entity class representing an employee in the Hotel_API system.
 */
@Entity
@Table(name = "Employee")
public class Employee {

    /**
     * Employee's unique identifier.
     */
    @Id
    @Column(name = "Employee_ID", nullable = false)
    private String employeeId;

    /**
     * Employee's email address.
     */
    @Column(name = "Email", nullable = false)
    private String email;

    /**
     * Employee's full name.
     */
    @Column(name = "Name", nullable = false)
    private String name;

    /**
     * Employee's phone number.
     */
    @Column(name = "Number", nullable = false)
    private String number;

    /**
     * Employee's address.
     */
    @Column(name = "Address", nullable = false)
    private String address;

    /**
     * Default constructor for Employee.
     */
    public Employee() {
    }

    /**
     * Constructs a new Employee with the given parameters.
     *
     * @param employeeId The unique identifier for the employee.
     * @param email The email address of the employee.
     * @param name The full name of the employee.
     * @param number The phone number of the employee.
     * @param address The address of the employee.
     */
    public Employee(String employeeId, String email, String name, String number, String address) {
        this.employeeId = employeeId;
        this.email = email;
        this.name = name;
        this.number = number;
        this.address = address;
    }

    /**
     * Returns the employee's unique identifier.
     *
     * @return The employee ID.
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets the employee's unique identifier.
     *
     * @param employeeId The employee ID to set.
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Returns the employee's email address.
     *
     * @return The email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the employee's email address.
     *
     * @param email The email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the employee's full name.
     *
     * @return The full name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the employee's full name.
     *
     * @param name The full name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the employee's phone number.
     *
     * @return The phone number.
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the employee's phone number.
     *
     * @param number The phone number to set.
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Returns the employee's address.
     *
     * @return The address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the employee's address.
     *
     * @param address The address to set.
     */
    public void setAddress(String address) {
        this.address = address;
    }
}
