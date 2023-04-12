package edu.sabanciuniv.exchangecurrency.exception;

public class NoSuchTransactionException extends RuntimeException {
    public NoSuchTransactionException(String msg) {
        super(msg);
    }
}
