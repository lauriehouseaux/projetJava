/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.InflaterInputStream;

/**
 *
 * @author Jarretier Adrien "jarretier.adrien@gmail.com"
 */
public final class FileReading {
    
    private FileReading(){}; // interdit l'instanciation de cette classe
    
    public static Byte[] ReadFile(File f) throws FileNotFoundException, IOException{
  				
	FileInputStream fis = new FileInputStream(f);
        
        InflaterInputStream decompresser = new InflaterInputStream(fis);
                
        ArrayList<Byte> LectureFichier = new ArrayList();
        int caract;
        
        try {
            while((caract = decompresser.read()) != -1){
                LectureFichier.add( (byte)caract );
            }
        }
        catch(IOException e) {
            throw new IOException("fichier "+f.getName()+" : "+e.getMessage());
        }
         
        return LectureFichier.toArray(new Byte[0]);         
               
    }
    
    public static String stringValue( Byte[] inflated ) {
        
        StringBuilder content = new StringBuilder();

        for (int i = 0; i < inflated.length; i++) {
            content.append((char)inflated[i].byteValue());
        }
        
        return content.toString();
        
    }
    
}
