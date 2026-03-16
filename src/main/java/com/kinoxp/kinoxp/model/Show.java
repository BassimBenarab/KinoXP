package com.kinoxp.kinoxp.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "`show`")

public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Movie movie;

    private String hallName;

    private LocalDateTime showTime;

    private int totalSeats;

    public Show() {}

    public Show(Movie movie, String hallName, LocalDateTime showTime, int totalSeats) {
        this.movie = movie;
        this.hallName = hallName;
        this.showTime = showTime;
        this.totalSeats = totalSeats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }
}