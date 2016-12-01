package com.rafsan.controller;

import com.rafsan.model.Booking;
import com.rafsan.repository.BookingRepository;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Api(name = "Hotel Booking API",
        description = "Provides a list of methods",
        stage = ApiStage.BETA)
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @RequestMapping(value = "/bookings", method = RequestMethod.GET)
    @ApiMethod(description = "Get all hotel bookings from database")
    public List<Booking> bookings(){

        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
    @ApiMethod(description = "Get all affordable deals")
    public List<Booking> affordable(@ApiPathParam(name = "price") @PathVariable double price){

        return bookingRepository.findByPriceLessThan(price);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiMethod(description = "Create a new entry")
    public List<Booking> create(@RequestBody Booking booking){

        bookingRepository.save(booking);

        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ApiMethod(description = "Remove from database")
    public List<Booking> remove(@ApiPathParam(name = "id") @PathVariable long id){

        bookingRepository.delete(id);

        return bookingRepository.findAll();
    }
}
