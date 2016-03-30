package model;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;



public class Commit extends GitObject{
    
    private Tree tree;
    private ArrayList< Commit > parents;
    private String authorName;
    private String authorMail;
    private String date;
    private String committerName;
    private String committerMail;
    private String message;
   
    public Commit(File _file, Git _gitInstance) throws IOException {
        
        super(_file, _gitInstance);
        
        String content = FileReading.stringValue( FileReading.ReadFile(_file) );
        
        System.out.println("-------------------------------------------------------");
        
        StringReader sr = new StringReader( content );
        BufferedReader bf = new BufferedReader( sr );
        
        String line = bf.readLine();
          
        System.out.println("tree : " + line.split(" ")[2]);
        
        line = bf.readLine();
        while( ! line.isEmpty() )
        {
            System.out.println("l : " + line);
//            switch( line.subSequence(beginIndex, endIndex) ) {
//             
//                
//                
//            }

            line = bf.readLine();
        }
        
        System.out.println("-------------------------------------------------------");

    }   
}