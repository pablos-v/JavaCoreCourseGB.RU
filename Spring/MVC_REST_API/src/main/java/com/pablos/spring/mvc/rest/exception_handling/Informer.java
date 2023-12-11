package com.pablos.spring.mvc.rest.exception_handling;

// этот класс нужен для преобразования сообщения от эксепшена в объект,
// который потом будет выдан в виде JSON
public class Informer {
    private String info;

    public Informer() {
    }

    public Informer(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
