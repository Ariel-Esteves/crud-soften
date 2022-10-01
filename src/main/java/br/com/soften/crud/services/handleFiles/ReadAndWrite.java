package br.com.soften.crud.services.handleFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
// comecei a fazer o estudo de leitura e escrita de arquivos com java, iniciei a implementação mas desisti em razão de
// tentar melhorar meu código refazendo as diversas funções, pretendo terminar esse recurso
public class ReadAndWrite{
    String path = "/home/ariel";

    public void readFile( ){
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.lines().map(e -> e.replace("(^$)", "\""));
        } catch (IOException e) {

        }
    }

}
