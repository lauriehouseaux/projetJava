package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public abstract class GitObject {
    private File gitObjectFile;
    protected String name;
    protected Git gitInstance;
    
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
        
    }
    
    public abstract ArrayList<GitObjectProperty> getProperties() throws IOException;
    
}
