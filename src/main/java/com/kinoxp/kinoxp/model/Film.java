package com.kinoxp.kinoxp.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int durationMinutes;
    private boolean is3d;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private List<Show> shows = new ArrayList<>();

    // constructors
    public Film() {}

    public Film(String title, int durationMinutes, boolean is3d) {
        this.title = title;
        this.durationMinutes = durationMinutes;
        this.is3d = is3d;
    }


    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(int durationMinutes) { this.durationMinutes = durationMinutes; }

//    public boolean isIs3d() { return is3d; }
//    public void setIs3d(boolean is3d) { this.is3d = is3d; }

    public List<Show> getShows() { return shows; }
}