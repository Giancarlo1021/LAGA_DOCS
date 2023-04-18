package COMP380.LAGA.Hotel_API.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

/**
 * A class that represents a customer in the hotel system.
 * This class is mapped to the "Customer" table in the database.
 */
@Entity
@Table(name = "Customer")
public class Customer {

    /**
     * Constructs a new Customer object with the given email, name, number, and address.
     *
     * @param email The email address of the customer.
     * @param name The name of the customer.
     * @param number The phone number of the customer.
     * @param address The address of the customer.
     */
    public Customer(String email, String name, String number, String address) {
        this.email = email;
        this.name = name;
        this.number = number;
        this.address = address;
    }

    /**
     * Retrieves the email address of the customer.
     *
     * @return The email address of the customer.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the customer.
     *
     * @param email The new email address of the customer.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the name of the customer.
     *
     * @return The name of the customer.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the customer.
     *
     * @param name The new name of the customer.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the phone number of the customer.
     *
     * @return The phone number of the customer.
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the phone number of the customer.
     *
     * @param number The new phone number of the customer.
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Retrieves the address of the customer.
     *
     * @return The address of the customer.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the customer.
     *
     * @param address The new address of the customer.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Default constructor required by JPA.
     */
    public Customer() {
    }

    /**
     * The email address of the customer.
     */
    @Id
    @Column(name = "Customer_Email", nullable = false)
    private String email;

    /**
     * The name of the customer.
     */
    @Column(name = "Name", nullable = false)
    private String name;

    /**
     * The phone number of the customer.
     */
    @Column(name = "Number", nullable = false)
    private String number;

    /**
     * The address of the customer.
     */
    @Column(name = "Address", nullable = false)
    private String address;

}
