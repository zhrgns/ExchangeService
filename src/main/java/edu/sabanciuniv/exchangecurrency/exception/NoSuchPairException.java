package edu.sabanciuniv.exchangecurrency.service;

public class NoSuchPairException extends RuntimeException {

    public NoSuchPairException(String s) {
        super(s);
    }
}
