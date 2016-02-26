package model;

import java.io.File;
import java.util.ArrayList;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author COT
 */
public class Git {
    private String dossierGit;  
    ArrayList <GitObject> objects = new ArrayList();
    
    // defini les types d'objets que l'on peut rencontrer dans .git/objects
    // cette enum correspond aux classes derivants de GitObject
    public enum ObjectType {
        BLOB, TREE, COMMIT, TAG,
        NONE
    }
    
    public static ObjectType getType( File _gitObject ) {
        
        return ObjectType.NONE;
        
    }
    
    public void Git(String adresse){
        File dossierObjects= new File(adresse,"objects");
        
        for (File f: dossierObjects.listFiles()){

            for (File f2: f.listFiles()){
                
                ObjectType type = getType(f2);
                
                switch(type){
                    
                    case BLOB:
                        objects.add(new Blob( f2.getAbsolutePath() ));
                        break;
                        
                    case TREE:
                        objects.add(new Tree( f2.getAbsolutePath() ));
                        break;
                        
                    case COMMIT:
                        objects.add(new Commit( f2.getAbsolutePath() ));
                        break;
                        
                    case TAG:
                        objects.add(new Tag( f2.getAbsolutePath() ));
                        break;
                }
            }
        }
    }

}
    