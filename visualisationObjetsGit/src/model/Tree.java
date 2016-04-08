package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;


public class Tree extends GitObject{
    
    private ArrayList<GitObject> childs;
    
    public Tree(File _file, Git _gitInstance) throws IOException {
        
        super(_file, _gitInstance);
        
        childs = new ArrayList<>();

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
            
            String content = Tree.stringValue( FileReading.ReadFile(getFile()) );
            
            StringReader sr = new StringReader( content );
            BufferedReader bf = new BufferedReader( sr );

            String line = bf.readLine();
            line = bf.readLine();   //  on passe l'en-tete
            
            while( line != null )
            {
                childs.add( gitInstance.find( line.split(" ")[2] ) );
                
                line = bf.readLine();
            }
            
            this.filled = true;
        }
    }

    @Override
    public ArrayList<GitObjectProperty> getProperties() throws IOException {
        
        this.fill();
        
        ArrayList<GitObjectProperty> properties = new ArrayList<>();
        
        for (GitObject child : childs) {
            properties.add(new GitObjectProperty("child", GitObjectPropertyType.OBJECT_REF, child));
        }
        
        
        return properties;
        
    }
    
}
