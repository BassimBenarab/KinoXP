package com.kinoxp.kinoxp.Service;

import com.kinoxp.kinoxp.Repository.ReservationRepository;
import com.kinoxp.kinoxp.model.Reservation;
import com.kinoxp.kinoxp.model.Show;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ShowService showService;

    public ReservationService(ReservationRepository reservationRepository, ShowService showService) {
        this.reservationRepository = reservationRepository;
        this.showService = showService;
    }
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation createReservation(Long showId, String customerName, int rowNumber, int seatNumber) {
        Show show = showService.findById(showId);

        double price = calculatePrice(show, rowNumber);

        Reservation reservation = new Reservation();
        reservation.setCustomerName(customerName);
        reservation.setRowNumber(rowNumber);
        reservation.setSeatNumber(seatNumber);
        reservation.setPrice(price);
        reservation.setShow(show);

        return reservationRepository.save(reservation);
    }

    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    private double calculatePrice(Show show, int rowNumber) {
        double basePrice = 100.0;

        if (rowNumber <= 2) {
            return 80.0;
        }

        int totalRows = 10;

        if (show.getTotalSeats() >= 100 && rowNumber >= totalRows - 1) {
            return 120.0;
        }

        return basePrice;
    }
}