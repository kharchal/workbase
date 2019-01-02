package ua.com.hav.workbase.exception;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(Integer id) {
        super(" id = " + id);
    }
}
