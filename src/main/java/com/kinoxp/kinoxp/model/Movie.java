package com.kinoxp.kinoxp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "film")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String genre;

    @Column(name = "duration_minutes")
    private int durationMinutes;

    private boolean is3d;

    @Column(name = "image_url")
    private String imageUrl;

    public Movie() {
    }
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public boolean isIs3d() {
        return is3d;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public void setIs3d(boolean is3d) {
        this.is3d = is3d;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}