package br.com.soften.crud.exceptions;

// foi usado em alguns casos, acredito que devo ter escapado em alguns casos
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException( Object id ){
        super("Resource Not Found id:" + id);
    }
}
