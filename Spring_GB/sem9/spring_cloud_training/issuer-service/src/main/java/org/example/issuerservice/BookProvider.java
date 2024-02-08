package org.example.issuerservice;

import org.example.Book;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

@Service
public class BookProvider {
    private final WebClient webClient; // реактивный веб-клиент

    private BookProvider(ReactorLoadBalancerExchangeFilterFunction reactorLoadBalancerExchangeFilterFunction) {
        webClient = WebClient
                .builder()
                .filter(reactorLoadBalancerExchangeFilterFunction) // балансировщик
                .build();
    }

    public UUID getRandomBookId() {
        Book randomBook = webClient.get()
                // на место book-service он подставит из эврики адрес микросервиса, который там зарегистрирован
                .uri("http://book-service/api/book/random")
                .retrieve() // извлечь
                .bodyToMono(Book.class) // преобразовать
                .block(); // не ждать

        return randomBook.getId();
    }
}
