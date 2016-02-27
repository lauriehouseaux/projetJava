package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Observable;



public class Git extends Observable{
    private File gitDirectory;  
    private ArrayList<GitObject> objects;
    
    // defini les types d'objets que l'on peut rencontrer dans .git/objects
    // cette enum correspond aux classes derivants de GitObject
    private enum ObjectType {
        BLOB, TREE, COMMIT, TAG,
        NONE
    }
    
    public static ObjectType getType( File _gitObject ) {
        
        return ObjectType.NONE;
        
    }
    
    public void Git(){
        gitDirectory = null;
        objects = new ArrayList();
    }
    
    public void setGitDirectory(File _gitDirectory){
        File objectsDirectory= new File(_gitDirectory,"objects");
        
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
    