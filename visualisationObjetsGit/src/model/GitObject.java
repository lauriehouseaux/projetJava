package model;

import java.io.File;


public abstract class GitObject {
    private File gitObjectFile;
    public String getAbsolutePath(){
        return gitObjectFile.getAbsolutePath();
    }
    public GitObject(File _gitObjectFile){
        
        gitObjectFile = _gitObjectFile;
        
    }
}
