package br.com.sweetspring.sweetspring.entity;

public class ResponseHttpAPI<T> {
    public boolean success;
    public String message;
    public T data;
}
