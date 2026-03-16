package com.kinoxp.kinoxp.Service;

import com.kinoxp.kinoxp.model.Show;
import com.kinoxp.kinoxp.Repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {

    private static ShowRepository showRepository = null;

    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    public List<Show> findAll() {
        return showRepository.findAll();
    }
    public List<Show> findByMovieId(Long movieId) {
        return showRepository.findByMovieId(movieId);
    }

    public static Show findById(Long id) {
        return showRepository.findById(id).orElse(null);
    }

    public Show save(Show show) {
        return showRepository.save(show);
    }

    public void deleteById(Long id) {
        showRepository.deleteById(id);
    }
}