package com.kinoxp.kinoxp.Controller;

import com.kinoxp.kinoxp.model.Movie;
import com.kinoxp.kinoxp.Service.MovieService;
import com.kinoxp.kinoxp.Service.ShowService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public String getAllMovies(Model model) {
        model.addAttribute("movies", movieService.findAll());
        model.addAttribute("movie", new Movie());
        return "movies";
    }

    @PostMapping("/save")
    public String saveMovie(@ModelAttribute Movie movie) {
        movieService.save(movie);
        return "redirect:/movies";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {
        movieService.deleteById(id);
        return "redirect:/movies";
    }
    @GetMapping("/{id}")
    public String getMovieDetails(@PathVariable Long id, Model model) {
        Movie movie = movieService.findById(id);
        model.addAttribute("movie", movie);
        model.addAttribute("shows", ShowService.findById(id));

        return "movies";
    }
}