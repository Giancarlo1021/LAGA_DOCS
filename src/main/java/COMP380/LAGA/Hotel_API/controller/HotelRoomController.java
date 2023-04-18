package COMP380.LAGA.Hotel_API.controller;

import COMP380.LAGA.Hotel_API.model.HotelRoom;
import COMP380.LAGA.Hotel_API.repository.HotelRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * The HotelRoomController class represents a RESTful API controller for handling hotel room-related requests.
 */
@RestController
@RequestMapping("/api/hotelroom")
public class HotelRoomController {

    @Autowired
    private HotelRoomRepository hotelRoomRepository;

    /**
     * Retrieves a list of all hotel rooms from the hotel room repository.
     *
     * @return A ResponseEntity containing the list of hotel rooms and an HTTP status code indicating the success of the operation.
     */
    @GetMapping
    public ResponseEntity<List<HotelRoom>> getAllHotelRooms() {
        List<HotelRoom> hotelRooms = hotelRoomRepository.findAll();
        return new ResponseEntity<>(hotelRooms, HttpStatus.OK);
    }

    /**
     * Retrieves a specific hotel room from the hotel room repository based on its ID.
     *
     * @param id The ID of the hotel room to retrieve.
     * @return A ResponseEntity containing the hotel room and an HTTP status code indicating the success of the operation.
     */
    @GetMapping("/{id}")
    public ResponseEntity<HotelRoom> getHotelRoomById(@PathVariable("id") String id) {
        Optional<HotelRoom> hotelRoom = hotelRoomRepository.findById(id);
        return hotelRoom.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Adds a new hotel room to the hotel room repository.
     *
     * @param hotelRoom The hotel room object to be added.
     * @return A ResponseEntity containing the created hotel room and an HTTP status code indicating the success of the operation.
     */
    @PostMapping
    public ResponseEntity<HotelRoom> createHotelRoom(@RequestBody HotelRoom hotelRoom) {
        HotelRoom newHotelRoom = hotelRoomRepository.save(hotelRoom);
        return new ResponseEntity<>(newHotelRoom, HttpStatus.CREATED);
    }

    /**
     * Updates an existing hotel room in the hotel room repository based on its ID.
     *
     * @param id The ID of the hotel room to update.
     * @param hotelRoom The updated hotel room object.
     * @return A ResponseEntity containing the updated hotel room and an HTTP status code indicating the success of the operation.
     */
    @PutMapping("/{id}")
    public ResponseEntity<HotelRoom> updateHotelRoom(@PathVariable("id") String id, @RequestBody HotelRoom hotelRoom) {
        Optional<HotelRoom> existingHotelRoom = hotelRoomRepository.findById(id);

        if (existingHotelRoom.isPresent()) {
            HotelRoom updatedHotelRoom = existingHotelRoom.get();
            updatedHotelRoom.setRoomId(hotelRoom.getRoomId());
            updatedHotelRoom.setRoomName(hotelRoom.getRoomName());
            updatedHotelRoom.setRoomNumber(hotelRoom.getRoomNumber());
            updatedHotelRoom.setStatus(hotelRoom.isStatus());

            hotelRoomRepository.save(updatedHotelRoom);
            return new ResponseEntity<>(updatedHotelRoom, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Deletes an existing hotel room from the hotel room repository based on its ID.
     *
     * @param id The ID of the hotel room to delete.
     * @return A ResponseEntity with no content and an HTTP status code indicating the success of the operation.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteHotelRoom(@PathVariable("id") String id) {
        hotelRoomRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
