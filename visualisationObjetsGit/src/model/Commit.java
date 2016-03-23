package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class Commit extends GitObject{
    
    private String authorName;
    private String parent;
    private String committer;
    private String mailCommitter;
    private String date;
    private String mailAuthor;
    private String message;
    
    public Commit(File _file) {
        
        super(_file);
        
        private void main(String[] args) throws FileNotFoundException{ 
      
         String filePath = ;
         
      
         try{ 
         
            BufferedReader buff = new BufferedReader(new FileReader(filePath)); 
         
            try { 
               String line; 
            // Lire le fichier ligne par ligne 
            // La boucle se termine quand la méthode affiche "null" 
 
               while ((line = buff.readLine()) != null) { 
                  
                
                // ajouter  ces 3 lignes <<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                  int index = line.indexOf("parent"); // partie de la ligne a garder
                  if(index > 0){ // si on trouve "parent"
                      
                      parent = line;
                  }
                     
                  }
                  
                  
                  
               }
 
    }
    
}
