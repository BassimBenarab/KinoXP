package com.kinoxp.kinoxp.Controller;
import com.kinoxp.kinoxp.Service.MovieService;
import com.kinoxp.kinoxp.model.Show;

import com.kinoxp.kinoxp.Service.ShowService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/shows")
public class ShowController {

    private final ShowService showService;
    private final MovieService movieService;

    public ShowController(ShowService showService, MovieService movieService) {
        this.showService = showService;
        this.movieService = movieService;
    }

    @GetMapping
    public String getAllShows(Model model) {
        model.addAttribute("shows", showService.findAll());
        model.addAttribute("movies", movieService.findAll());
        model.addAttribute("show", new Show());
        return "shows";
    }

    @PostMapping("/save")
    public String saveShow(@ModelAttribute Show show) {
        showService.save(show);
        return "redirect:/shows";
    }

    @GetMapping("/delete/{id}")
    public String deleteShow(@PathVariable Long id) {
        showService.deleteById(id);
        return "redirect:/shows";
    }
}