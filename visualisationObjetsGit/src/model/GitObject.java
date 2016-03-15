package model;

import java.io.File;


public abstract class GitObject {
    private File gitObjectFile;
    
    public File getFile(){
        return gitObjectFile;
    }
    
    public GitObject(File _gitObjectFile){
        
        gitObjectFile = _gitObjectFile;
        
    }
    
}
