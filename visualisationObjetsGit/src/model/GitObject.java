package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public abstract class GitObject {
    private File gitObjectFile;
    protected String name;
    protected Git gitInstance;
    protected boolean filled; 
            // permet de savoir si les proprietes de l'objet ont ete recuperees
            // c.a.d si fill() a ete appelee, methode qui parse le fichier
    
    public File getFile(){
        return gitObjectFile;
    }
    
    public String getName(){
        return name;
    }
    
    public GitObject(File _gitObjectFile, Git _gitInstance){
        
        gitObjectFile = _gitObjectFile;
        
        name = gitObjectFile.getParentFile().getName()+gitObjectFile.getName();
        
        gitInstance = _gitInstance;
        
        this.filled = false;
        
    }
    
    protected abstract void fill() throws IOException;
    
    /**
     *
     * cette fonction permet de recuperer une liste des differents champs
     * presents dans ce GitObject
     * 
     * @see GitObjectProperty
     * 
     * @return la liste des proprietes de ce GitObject
     * @throws IOException
     */
    public abstract ArrayList<GitObjectProperty> getProperties() throws IOException;
    
}
