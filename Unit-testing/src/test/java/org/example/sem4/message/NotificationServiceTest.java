package org.example.sem4.message;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NotificationServiceTest {

    @Test
    void sendNotification() {
        MessageService messageService = mock(MessageService.class);
        String message = "foo";
        String recipient = "bar";
        NotificationService notificationService = new NotificationService(messageService);

        notificationService.sendNotification(message, recipient);

        verify(messageService, times(1)).sendMessage(message, recipient);
    }
}