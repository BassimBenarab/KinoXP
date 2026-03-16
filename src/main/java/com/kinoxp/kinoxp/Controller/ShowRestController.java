package com.kinoxp.kinoxp.Controller;

import com.kinoxp.kinoxp.model.Show;
import com.kinoxp.kinoxp.Service.ShowService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shows")
public class ShowRestController {

    private final ShowService showService;

    public ShowRestController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping("/movie/{movieId}")
    public List<Show> getShowsByMovieId(@PathVariable int movieId) {
        return showService.findByMovieId((long) movieId);
    }
}
