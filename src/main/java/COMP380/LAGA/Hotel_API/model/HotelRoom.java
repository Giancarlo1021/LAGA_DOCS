package COMP380.LAGA.Hotel_API.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * HotelRoom entity class representing a room within a hotel in the Hotel_API system.
 */
@Entity
@Table(name = "HotelRoom")
public class HotelRoom {

    /**
     * HotelRoom's unique identifier.
     */
    @Id
    @Column(name = "Room_ID", nullable = false)
    private String roomId;

    /**
     * HotelRoom's name.
     */
    @Column(name = "Room_Name", nullable = false)
    private String roomName;

    /**
     * HotelRoom's number.
     */
    @Column(name = "Room_Number", nullable = false)
    private int roomNumber;

    /**
     * HotelRoom's availability status.
     */
    @Column(name = "Status", nullable = false)
    private boolean status;

    /**
     * Default constructor for HotelRoom.
     */
    public HotelRoom() {
    }

    /**
     * Constructs a new HotelRoom with the given parameters.
     *
     * @param roomId The unique identifier for the hotel room.
     * @param roomName The name of the hotel room.
     * @param roomNumber The room number within the hotel.
     * @param status The availability status of the hotel room.
     */
    public HotelRoom(String roomId, String roomName, int roomNumber, boolean status) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomNumber = roomNumber;
        this.status = status;
    }

    /**
     * Returns the hotel room's unique identifier.
     *
     * @return The hotel room ID.
     */
    public String getRoomId() {
        return roomId;
    }

    /**
     * Sets the hotel room's unique identifier.
     *
     * @param roomId The hotel room ID to set.
     */
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    /**
     * Returns the hotel room's name.
     *
     * @return The hotel room name.
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * Sets the hotel room's name.
     *
     * @param roomName The hotel room name to set.
     */
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    /**
     * Returns the hotel room's number.
     *
     * @return The hotel room number.
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Sets the hotel room's number.
     *
     * @param roomNumber The hotel room number to set.
     */
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * Returns the hotel room's availability status.
     *
     * @return The hotel room status.
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Sets the hotel room's availability status.
     *
     * @param status The hotel room status to set.
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Checks the availability of the hotel room.
     *
     * @return The availability status of the hotel room.
     */
    public boolean checkAvailability() {
        return status;
    }
}
