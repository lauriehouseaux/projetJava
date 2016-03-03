package model;

import exceptions.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;



public class Git extends Observable{
    private File gitDirectory;  
    private ArrayList<GitObject> objects;
    
    // defini les types d'objets que l'on peut rencontrer dans .git/objects
    // cette enum correspond aux classes derivants de GitObject
    private enum ObjectType {
        BLOB, TREE, COMMIT, TAG,
        NONE
    }
    
    public static byte[] ReadFile(File f) throws DataFormatException, FileNotFoundException, IOException{
		FileInputStream fis;
		int octetLu;
			
    //creation d'un flux d'entrée ayant pour source un fichier nommé 			
    //source,cette instanciation peut lever une exception de type 				
		fis = new FileInputStream(f);
                // initialisation d'un tableau d'octet
                byte[] b = new byte[30];
                // placement de chaque octet lu dans le tableau
                octetLu = fis.read(b);
                        
                        //System.out.println(octetLu);
                    
			//lecture des données
			Inflater decompresser = new Inflater();
                        // decompression du fichier par rapport a la taille de notre tableau
                        decompresser.setInput(b,0,octetLu);
                        // initialisation d'un tableau d'octet
                        byte[] res = new byte[100];
                        //decompression du fichier + recuperation de la taille du tableau 
                        int taille = decompresser.inflate(res);
                        decompresser.end();
                        
                        return res;
	}
    
    
    
    public static ObjectType getType( File _gitObject ) throws DataFormatException, IOException {
          byte[] file = ReadFile(_gitObject);
          StringBuilder mot = new StringBuilder();
          for (int i = 0; i < 10; i++) {
             mot.append((char)file[i]);
                    }
          if(mot.toString().startsWith("tree")){
            return ObjectType.TREE;
          }
          
          if(mot.toString().startsWith("tag")){
            return ObjectType.TAG;
          }
          
          if(mot.toString().startsWith("blob")){
            return ObjectType.BLOB;
          }
          
          if(mot.toString().startsWith("commit")){
            return ObjectType.COMMIT;
          }
          
          else {
              return ObjectType.NONE;
          }
    }
    
    public void Git(){
        gitDirectory = null;
        objects = new ArrayList();
    }
    
    public void setGitDirectory(File _gitDirectory) throws DirectoryDoesNotExistException, NotGitDirectoryException, DataFormatException, IOException{
        
        if(!_gitDirectory.exists()) {
            throw new DirectoryDoesNotExistException("Le dossier <" + gitDirectory.getAbsolutePath() + "> n'existe pas");
        }
        
        if( !_gitDirectory.getName().equals(".git") ) {
            throw new NotGitDirectoryException("Le dossier <" + gitDirectory.getAbsolutePath() + "> n'est pas un dossier <.git>");
        }
        
        File objectsDirectory= new File(_gitDirectory,"objects");
        
        if(!objectsDirectory.exists()) {
            throw new DirectoryDoesNotExistException("Le dossier <" + gitDirectory.getName()+ "> n'existe pas");
        }
        
        gitDirectory = _gitDirectory;
        
        for (File f: objectsDirectory.listFiles()){

            for (File f2: f.listFiles()){
                
                ObjectType type = getType(f2);
                
                switch(type){
                    
                    case BLOB:
                        objects.add(new Blob( f2 ));
                        break;
                        
                    case TREE:
                        objects.add(new Tree( f2 ));
                        break;
                        
                    case COMMIT:
                        objects.add(new Commit( f2 ));
                        break;
                        
                    case TAG:
                        objects.add(new Tag( f2 ));
                        break;
                }
            }
        }
    }

}
    