package br.com.soften.crud.exceptions;

// talves tentar tratar esse erro seja inútil, mas eu acabei criando para ver como funcionava
public class ArgNullFoundException extends RuntimeException{
    public ArgNullFoundException( ){
        super("Arg with not value inserted founded, a null field");
    }
}
