package model;

import java.io.File;
import java.io.IOException;


public class Commit extends GitObject{
    
    
    public Commit(File _file) throws IOException {
        
        super(_file);
        
        System.out.println("-------------------------------------------------------");
        System.out.println("nom : " + this.getName());
        System.out.println(FileReading.stringValue( FileReading.ReadFile(_file) ));
        System.out.println("-------------------------------------------------------");
//        
    }
    
}
