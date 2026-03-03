package com.kinoxp.kinoxp.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String customerEmail;

    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne(optional = false)
    @JoinColumn(name = "show_id")
    private Show show;




    public Reservation(String customerName, String customerEmail, Show show) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.show = show;
    }

    public Reservation() {

    }


    public Long getId() { return id; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public Show getShow() { return show; }
    public void setShow(Show show) { this.show = show; }
}