package com.practo.service.serviceimpl;

import com.practo.entity.Booking;
import com.practo.payload.BookingDto;
import com.practo.repository.BookingRepository;
import com.practo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpli implements BookingService {

    @Autowired
    private BookingRepository bookingRepo;

    @Override
    public void bookAnAppointment(BookingDto dto) {
        List<String> availableTimeSlots = new ArrayList<>();
        availableTimeSlots.add("10:15 AM");
        availableTimeSlots.add("11:15 AM");
        availableTimeSlots.add("12:15 PM");

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(() -> {

            System.out.println("Task executed every 24 hours");

            availableTimeSlots.clear();
            availableTimeSlots.add("10:15 AM");
            availableTimeSlots.add("11:15 AM");
            availableTimeSlots.add("12:15 PM");

            }, 0, 24, TimeUnit.HOURS);

        Booking booking =new Booking();
        for (String slots:availableTimeSlots
        ) {
            if (slots.equals(dto.getBookingTime())){
                booking.setBookingTime(dto.getBookingTime());
                availableTimeSlots.remove(slots);
            }
        }

        booking.setDoctorId(dto.getDoctorId());
        booking.setPatientId(dto.getPatientId());

        if(booking.getBookingTime()!=null) {
            bookingRepo.save(booking);
        }else{
            System.out.println("Time slot not avlaible");
        }
    }

    }

