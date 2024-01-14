package org.example.sem4.hotel;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookingServiceTest {

    @Test
    void bookRoom() {
        HotelService hotelService = mock(HotelService.class);
        int testRoomNumber = 3;
        when(hotelService.isRoomAvailable(testRoomNumber)).thenReturn(true);
        BookingService service = new BookingService(hotelService);

        boolean first = service.bookRoom(testRoomNumber);

        assertTrue(first);
    }
}