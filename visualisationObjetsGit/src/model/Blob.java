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
    public ArrayList<GitObjectProperty> getProperties() throws IOException {
        
        ArrayList<GitObjectProperty> properties = new ArrayList<>();
        properties.add(new GitObjectProperty("", GitObjectPropertyType.STRING, this.toString()));
        
        return properties;
    }
    
}
