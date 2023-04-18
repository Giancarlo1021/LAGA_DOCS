package COMP380.LAGA.Hotel_API.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User entity class representing a user in the Hotel_API system.
 */
@Entity
@Table(name = "User")
public class User {

    /**
     * User's unique identifier.
     */
    @Id
    @Column(name = "User_ID", nullable = false)
    private String userId;

    /**
     * User's first name.
     */
    @Column(name = "First_Name", nullable = false)
    private String firstName;

    /**
     * User's last name.
     */
    @Column(name = "Last_Name", nullable = false)
    private String lastName;

    /**
     * User's phone number.
     */
    @Column(name = "Phone_Number", nullable = false)
    private int phoneNumber;

    /**
     * User's email address.
     */
    @Column(name = "Email", nullable = false)
    private String email;

    /**
     * User's address.
     */
    @Column(name = "Address", nullable = false)
    private String address;

    /**
     * Default constructor for User.
     */
    public User() {
    }

    /**
     * Constructs a new User with the given parameters.
     *
     * @param userId      The unique identifier for the user.
     * @param firstName   The user's first name.
     * @param lastName    The user's last name.
     * @param phoneNumber The user's phone number.
     * @param email       The user's email address.
     * @param address     The user's address.
     */
    public User(String userId, String firstName, String lastName, int phoneNumber, String email, String address) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    /**
     * Returns the user's unique identifier.
     *
     * @return The user ID.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the user's unique identifier.
     *
     * @param userId The user ID to set.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Returns the user's first name.
     *
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the user's first name.
     *
     * @param firstName The first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the user's last name.
     *
     * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the user's last name.
     *
     * @param lastName The last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the user's phone number.
     *
     * @return The phone number.
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the user's phone number.
     *
     * @param phoneNumber The phone number to set.
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the user's email address.
     *
     * @return The email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user's email address.
     *
     * @param email The email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the user's address.
     *
     * @return The address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the user's address.
     *
     * @param address The address to set.
     */
    public void setAddress(String address) {
        this.address = address;
    }
}

