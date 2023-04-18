package COMP380.LAGA.Hotel_API.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Reservation entity class representing a reservation in the Hotel_API system.
 */
@Entity
@Table(name = "Reservation")
public class Reservation {

    /**
     * Reservation's unique identifier.
     */
    @Id
    @Column(name = "Reservation_ID", nullable = false)
    private String reservationId;

    /**
     * Date of the reservation.
     */
    @Column(name = "Date", nullable = false)
    private java.sql.Date date;

    /**
     * Customer's name associated with the reservation.
     */
    @Column(name = "Customer_Name", nullable = false)
    private String customerName;

    /**
     * Room number associated with the reservation.
     */
    @Column(name = "Room_Number", nullable = false)
    private int roomNumber;

    /**
     * Default constructor for Reservation.
     */
    public Reservation() {
    }

    /**
     * Constructs a new Reservation with the given parameters.
     *
     * @param reservationId The unique identifier for the reservation.
     * @param date The date of the reservation.
     * @param customerName The customer's name associated with the reservation.
     * @param roomNumber The room number associated with the reservation.
     */
    public Reservation(String reservationId, java.sql.Date date, String customerName, int roomNumber) {
        this.reservationId = reservationId;
        this.date = date;
        this.customerName = customerName;
        this.roomNumber = roomNumber;
    }

    /**
     * Returns the reservation's unique identifier.
     *
     * @return The reservation ID.
     */
    public String getReservationId() {
        return reservationId;
    }

    /**
     * Sets the reservation's unique identifier.
     *
     * @param reservationId The reservation ID to set.
     */
    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    /**
     * Returns the reservation's date.
     *
     * @return The reservation date.
     */
    public java.sql.Date getDate() {
        return date;
    }

    /**
     * Sets the reservation's date.
     *
     * @param date The reservation date to set.
     */
    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    /**
     * Returns the customer's name associated with the reservation.
     *
     * @return The customer's name.
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets the customer's name associated with the reservation.
     *
     * @param customerName The customer's name to set.
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Returns the room number associated with the reservation.
     *
     * @return The room number.
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Sets the room number associated with the reservation.
     *
     * @param roomNumber The room number to set.
     */
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
}
