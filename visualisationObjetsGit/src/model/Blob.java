package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Blob extends GitObject{
    

    public Blob(File _file, Git _gitInstance) throws IOException {
        

        super(_file, _gitInstance);
        
//        System.out.println("-------------------------------------------------------");
//        System.out.println("nom : " + this.getName());
//        System.out.println(FileReading.stringValue( FileReading.ReadFile(_file) ));
//        System.out.println("-------------------------------------------------------");
        
    }

    @Override
    public ArrayList<ObjectProperty> getProperties() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
