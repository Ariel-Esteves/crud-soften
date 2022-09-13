package br.com.soften.crud.services.handleFiles;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.hibernate.validator.constraints.ScriptAssert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

public class ReadAndWrite {
    String path = "/home/ariel";
    public void readFile(){
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
           br.lines().map(e-> e.replace("(^$)","\""));
        }catch(IOException e){

        }
    }

}
