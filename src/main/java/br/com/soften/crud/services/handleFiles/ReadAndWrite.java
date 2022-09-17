package br.com.soften.crud.services.handleFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndWrite{
    String path = "/home/ariel";

    public void readFile( ){
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.lines().map(e -> e.replace("(^$)", "\""));
        } catch (IOException e) {

        }
    }

}
