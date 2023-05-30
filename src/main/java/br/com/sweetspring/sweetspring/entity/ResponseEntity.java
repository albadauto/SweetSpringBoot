package br.com.sweetspring.sweetspring.entity;

public class ResponseEntity<T> {
    public boolean success;
    public String message;
    public T data;
}
