package services;

public class ServiceRuntimeExeption extends RuntimeException {
    public ServiceRuntimeExeption(String s) {
        super(s);
    }

    public ServiceRuntimeExeption(String s, Throwable throwable) {
        super(s, throwable);
    }
}
