package com.rafsan.repository;

import com.rafsan.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private BookingRepository bookingRepository;

    public DatabaseSeeder(BookingRepository bookingRepository) {

        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        List<Booking> bookings = Arrays.asList(
                new Booking("Marion Lodge",200.75, 5),
                new Booking("Welcome Lodge",118, 4),
                new Booking("Moon Side",167.20, 2),
                new Booking("Verizone",275, 2),
                new Booking("Moonlight Diner",129.67, 3)
        );

        bookingRepository.save(bookings);
    }
}
