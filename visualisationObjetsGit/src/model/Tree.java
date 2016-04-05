package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Tree extends GitObject{
    
    private ArrayList<GitObject> childs;
    
    public Tree(File _file, Git _gitInstance) throws IOException {
        
        super(_file, _gitInstance);
        
        
//        System.out.println("-------------------------------------------------------");
//        System.out.println("nom : " + this.getName());
//        System.out.println(stringValue( FileReading.ReadFile(_file) ));
//        System.out.println("-------------------------------------------------------");

    }
    // lecture de l'arbre de façon lisible pour un humain
     public static String stringValue( Byte[] inflated ) {
        
        StringBuilder content = new StringBuilder();
        
        int i = 0;
        char c;
        // affichage de l'entete
        do {
            c = (char)inflated[i].byteValue();
            content.append(c);
            i++;
        }while (c != '\0');
        content.append('\n');
        
        // pour chaque entree on fait la meme chose
        while(i < inflated.length) {
            // affichage du nom
            do {
                c = (char)inflated[i].byteValue();
                content.append(c);
                i++;
            }while (c != '\0');
            content.append(" ");
            
            // recuperation de la cle du fichier 
            for(int j = 0; j<20; j++){
                content.append(String.format("%02x", inflated[i]));
                i++;
            } 
            content.append('\n');
        }
        
        return content.toString();
        
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
        properties.add(new GitObjectProperty("", GitObjectPropertyType.STRING, this.toString()));
        
        return properties;
        
    }
    
}
