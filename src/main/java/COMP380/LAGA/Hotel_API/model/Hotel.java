package COMP380.LAGA.Hotel_API.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Hotel entity class representing a hotel in the Hotel_API system.
 */
@Entity
@Table(name = "Hotel")
public class Hotel {

    /**
     * Hotel's unique identifier.
     */
    @Id
    @Column(name = "Hotel_ID", nullable = false)
    private String hotelId;

    /**
     * Hotel's name.
     */
    @Column(name = "Name", nullable = false)
    private String name;

    /**
     * Hotel's address.
     */
    @Column(name = "Address", nullable = false)
    private String address;

    /**
     * Hotel's phone number.
     */
    @Column(name = "Phone_Number", nullable = false)
    private int phoneNumber;

    /**
     * Default constructor for Hotel.
     */
    public Hotel() {
    }

    /**
     * Constructs a new Hotel with the given parameters.
     *
     * @param hotelId The unique identifier for the hotel.
     * @param name The name of the hotel.
     * @param address The address of the hotel.
     * @param phoneNumber The phone number of the hotel.
     */
    public Hotel(String hotelId, String name, String address, int phoneNumber) {
        this.hotelId = hotelId;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the hotel's unique identifier.
     *
     * @return The hotel ID.
     */
    public String getHotelId() {
        return hotelId;
    }

    /**
     * Sets the hotel's unique identifier.
     *
     * @param hotelId The hotel ID to set.
     */
    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    /**
     * Returns the hotel's name.
     *
     * @return The hotel name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the hotel's name.
     *
     * @param name The hotel name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the hotel's address.
     *
     * @return The hotel address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the hotel's address.
     *
     * @param address The hotel address to set.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns the hotel's phone number.
     *
     * @return The hotel phone number.
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the hotel's phone number.
     *
     * @param phoneNumber The hotel phone number to set.
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

