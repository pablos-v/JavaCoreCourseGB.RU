package org.example.sem4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreditCardTest {
    CreditCard creditCardMock;

    @BeforeEach
    void setUp() {
        creditCardMock = mock(CreditCard.class);

    }

    @Test
    void charge() {
        PaymentForm paymentForm = new PaymentForm(creditCardMock);
        double amount = 100.7;
        paymentForm.pay(amount);


        verify(creditCardMock, times(1)).charge(amount);

    }
}