package com.rafsan.repository;

import com.rafsan.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long>{

    List<Booking> findByPriceLessThan(double price);
}
