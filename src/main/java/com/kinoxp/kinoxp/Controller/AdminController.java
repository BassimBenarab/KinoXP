package com.kinoxp.kinoxp.Controller;

import com.kinoxp.kinoxp.Service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    private final ReservationService reservationService;

    public AdminController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/admin/reservations")
    public String showAllReservations(Model model) {
        model.addAttribute("reservations", reservationService.findAll());
        return "admin-reservations";
    }
}