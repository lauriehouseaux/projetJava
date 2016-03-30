package model;

import java.io.File;


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
    
}
