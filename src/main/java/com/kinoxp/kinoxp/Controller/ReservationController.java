package com.kinoxp.kinoxp.Controller;

import com.kinoxp.kinoxp.Service.ReservationService;
import com.kinoxp.kinoxp.Service.ShowService;
import com.kinoxp.kinoxp.model.Reservation;
import com.kinoxp.kinoxp.model.Show;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;
    private final ShowService showService;

    public ReservationController(ReservationService reservationService, ShowService showService) {
        this.reservationService = reservationService;
        this.showService = showService;
    }

    @GetMapping("/show/{id}")
    public String showReservationPage(@PathVariable Long id, Model model) {
        Show show = showService.findById(id);

        model.addAttribute("show", show);

        return "reservations";
    }

    @PostMapping("/create")
    public String createReservation(@RequestParam Long showId,
                                    @RequestParam String customerName,
                                    @RequestParam int rowNumber,
                                    @RequestParam int seatNumber,
                                    Model model ) {

        Reservation reservation = reservationService.createReservation(showId, customerName, rowNumber, seatNumber);

        model.addAttribute("reservation", reservation);

        return "reservation-confirmation";
    }
}
