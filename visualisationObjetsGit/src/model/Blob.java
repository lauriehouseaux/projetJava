package model;

import java.io.File;
import java.io.IOException;


public class Blob extends GitObject{
    

    public Blob(File _file, Git _gitInstance) throws IOException {
        

        super(_file, _gitInstance);
        
//        System.out.println("-------------------------------------------------------");
//        System.out.println("nom : " + this.getName());
//        System.out.println(FileReading.stringValue( FileReading.ReadFile(_file) ));
//        System.out.println("-------------------------------------------------------");
        
    }
    
}
