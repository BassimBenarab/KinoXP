package com.kinoxp.kinoxp.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startDateTime;

    @ManyToOne(optional = false)
    @JoinColumn(name = "film_id")
    private Film film;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();


    public Show() {}

    public Show(LocalDateTime startDateTime, Film film) {
        this.startDateTime = startDateTime;
        this.film = film;
    }


    public Long getId() { return id; }

    public LocalDateTime getStartDateTime() { return startDateTime; }
    public void setStartDateTime(LocalDateTime startDateTime) { this.startDateTime = startDateTime; }

    public Film getFilm() { return film; }
    public void setFilm(Film film) { this.film = film; }

    public List<Reservation> getReservations() { return reservations; }
}