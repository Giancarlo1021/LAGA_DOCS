package COMP380.LAGA.Hotel_API.controller;

import COMP380.LAGA.Hotel_API.model.Reservation;
import COMP380.LAGA.Hotel_API.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * The ReservationController class represents a RESTful API controller for handling reservation-related requests.
 */
@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    /**
     * Retrieves a list of all reservations from the reservation repository.
     *
     * @return A ResponseEntity containing the list of reservations and an HTTP status code indicating the success of the operation.
     */
    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    /**
     * Retrieves a specific reservation from the reservation repository based on its ID.
     *
     * @param id The ID of the reservation to retrieve.
     * @return A ResponseEntity containing the reservation and an HTTP status code indicating the success of the operation.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable("id") String id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        return reservation.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Adds a new reservation to the reservation repository.
     *
     * @param reservation The reservation object to be added.
     * @return A ResponseEntity containing the created reservation and an HTTP status code indicating the success of the operation.
     */
    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        Reservation newReservation = reservationRepository.save(reservation);
        return new ResponseEntity<>(newReservation, HttpStatus.CREATED);
    }

    /**
     * Updates an existing reservation in the reservation repository based on its ID.
     *
     * @param id The ID of the reservation to update.
     * @param reservation The updated reservation object.
     * @return A ResponseEntity containing the updated reservation and an HTTP status code indicating the success of the operation.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable("id") String id, @RequestBody Reservation reservation) {
        Optional<Reservation> existingReservation = reservationRepository.findById(id);
        if (existingReservation.isPresent()) {
            Reservation updatedReservation = existingReservation.get();
            updatedReservation.setReservationId(reservation.getReservationId());
            updatedReservation.setDate(reservation.getDate());
            updatedReservation.setCustomerName(reservation.getCustomerName());
            updatedReservation.setRoomNumber(reservation.getRoomNumber());

            reservationRepository.save(updatedReservation);
            return new ResponseEntity<>(updatedReservation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Deletes an existing reservation from the reservation repository based on its ID.
     *
     * @param id The ID of the reservation to delete.
     * @return A ResponseEntity with no content and an HTTP status code indicating the success of the operation.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReservation(@PathVariable("id") String id) {
        Optional<Reservation> existingReservation = reservationRepository.findById(id);
        if (existingReservation.isPresent()) {
            reservationRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
