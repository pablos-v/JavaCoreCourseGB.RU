package org.example.sem4;

public class WebService {
    HttpClient client;

    public WebService(HttpClient client) {
        this.client = client;
    }

    public String get(String url){
        return client.get(url);
    }
}
