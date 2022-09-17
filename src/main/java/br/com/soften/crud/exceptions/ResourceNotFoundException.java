package br.com.soften.crud.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException( Object id ){
        super("Resource Not Found id:" + id);
    }
}
