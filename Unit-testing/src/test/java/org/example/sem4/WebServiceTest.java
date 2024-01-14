package org.example.sem4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WebServiceTest {

    @Test
    void get() {
        HttpClient client = mock(HttpClient.class);
        WebService ws = new WebService(client);
        String url = "qwer";
        when(client.get(any())).thenReturn(url + " запрос выполнен");

        String res = ws.get(url);

        assertEquals(url + " запрос выполнен", res);
    }
}