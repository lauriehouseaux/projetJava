package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Tag extends GitObject{
   
    private GitObject objetReference;
    
    public Tag(File _file, Git _gitInstance) throws IOException {
        
        super(_file, _gitInstance);
        
        name = _file.getName();
        
        FileReader fr = new FileReader(_file);
        BufferedReader bf = new BufferedReader(fr);
        
//        System.out.println("-------------------------------------------------------");
//        System.out.println("nom : " + this.getName());
//        System.out.println( bf.readLine() );
//        System.out.println("-------------------------------------------------------");
        
        
    }

    @Override
    protected void fill() throws IOException {
        
        if ( !this.filled ) {
            
           
            this.filled = true;
        }
    }

    @Override
    public ArrayList<GitObjectProperty> getProperties() throws IOException {
        
        this.fill();
        
        ArrayList<GitObjectProperty> properties = new ArrayList<>();
      //  properties.add( new GitObjectProperty( "Test" , GitObjectPropertyType.OBJECT_REF , tag ) );
        return properties;
    }
    
}
