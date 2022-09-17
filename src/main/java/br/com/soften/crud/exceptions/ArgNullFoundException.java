package br.com.soften.crud.exceptions;


public class ArgNullFoundException extends RuntimeException{
    public ArgNullFoundException( ){
        super("Arg with not value inserted founded, a null field");
    }
}
