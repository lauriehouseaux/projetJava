package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Tag extends GitObject{
    
    public Tag(File _file) throws IOException {
        
        super(_file);
        
//        FileReader fr = new FileReader(_file);
//        BufferedReader bf = new BufferedReader(fr);
//        
//        System.out.println("-------------------------------------------------------");
//        System.out.println("nom : " + this.getName());
//        System.out.println( bf.readLine() );
//        System.out.println("-------------------------------------------------------");
        
        
    }
    
}
