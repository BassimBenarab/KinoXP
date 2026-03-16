package com.kinoxp.kinoxp.Repository;
import com.kinoxp.kinoxp.model.Reservation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByShowId(Long showId);
}