package COMP380.LAGA.Hotel_API.controller;

import COMP380.LAGA.Hotel_API.model.*;
import COMP380.LAGA.Hotel_API.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * The HotelController class represents a RESTful API controller for handling hotel-related requests.
 */
@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

    /**
     * Retrieves a list of all hotels from the hotel repository.
     *
     * @return A ResponseEntity containing the list of hotels and an HTTP status code indicating the success of the operation.
     */
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    /**
     * Retrieves a specific hotel from the hotel repository based on its ID.
     *
     * @param id The ID of the hotel to retrieve.
     * @return A ResponseEntity containing the hotel and an HTTP status code indicating the success of the operation.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable("id") String id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        return hotel.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Adds a new hotel to the hotel repository.
     *
     * @param hotel The hotel object to be added.
     * @return A ResponseEntity containing the created hotel and an HTTP status code indicating the success of the operation.
     */
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel newHotel = hotelRepository.save(hotel);
        return new ResponseEntity<>(newHotel, HttpStatus.CREATED);
    }

    /**
     * Updates an existing hotel in the hotel repository based on its ID.
     *
     * @param id The ID of the hotel to update.
     * @param hotel The updated hotel object.
     * @return A ResponseEntity containing the updated hotel and an HTTP status code indicating the success of the operation.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable("id") String id, @RequestBody Hotel hotel) {
        Optional<Hotel> existingHotel = hotelRepository.findById(id);
        if (existingHotel.isPresent()) {
            Hotel updatedHotel = existingHotel.get();
            updatedHotel.setName(hotel.getName());
            updatedHotel.setAddress(hotel.getAddress());
            updatedHotel.setPhoneNumber(hotel.getPhoneNumber());
            hotelRepository.save(updatedHotel);
            return new ResponseEntity<>(updatedHotel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Deletes an existing hotel from the hotel repository based on its ID.
     *
     * @param id The ID of the hotel to delete.
     * @return A ResponseEntity with no content and an HTTP status code indicating the success of the operation.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHotel(@PathVariable("id") String id) {
        Optional<Hotel> existingHotel = hotelRepository.findById(id);
        if (existingHotel.isPresent()) {
            hotelRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
