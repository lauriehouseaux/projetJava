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
    private String dateWritten;
    
    private String committerName;
    private String committerMail;
    private String dateCommitted;
    
    private String message;
   
    public Commit(File _file, Git _gitInstance) throws IOException {
        
        super(_file, _gitInstance);
        
        parents = new ArrayList<>();
        
        String content = FileReading.stringValue( FileReading.ReadFile(_file) );
        
//        System.out.println("-------------------------------------------------------");
        
        StringReader sr = new StringReader( content );
        BufferedReader bf = new BufferedReader( sr );
        
        String line = bf.readLine();
          
        tree = (Tree)gitInstance.find( line.split(" ")[2] );
        
        line = bf.readLine();
        
        int i;
        
        while( ! line.isEmpty() )
        {
            switch( line.charAt(0)) {
             
                case 'p':
                    parents.add( (Commit)gitInstance.find( line.split(" ")[1] ) );
                    break;
                    
                case 'a':
                    String[] wordsAuthorLine = line.split(" ");
                    
                    authorName = wordsAuthorLine[1];
                    
                    i=2;
                    while( !wordsAuthorLine[i].startsWith("<") ) {
                        
                        authorName += ' '+wordsAuthorLine[i];
                        i++;
                    }
//                    System.out.println("a : " + authorName);
                    
                    authorMail = wordsAuthorLine[i++].replaceAll("[<>]", "");
//                    System.out.println("am : " + authorMail);
                    
                    dateWritten = wordsAuthorLine[i++]+" "+wordsAuthorLine[i];
//                    System.out.println("dw : " + dateWritten);
                    break;
                    
                case 'c':
                    String[] wordsCommitterLine = line.split(" ");
                    
                    committerName = wordsCommitterLine[1];
                    
                    i=2;
                    while( !wordsCommitterLine[i].startsWith("<") ) {
                        
                        committerName += ' '+wordsCommitterLine[i];
                        i++;
                    }
//                    System.out.println("c : " + committerName);
                    
                    committerMail = wordsCommitterLine[i++].replaceAll("[<>]", "");
//                    System.out.println("cm : " + committerMail);
                    
                    dateCommitted = wordsCommitterLine[i++]+" "+wordsCommitterLine[i];
//                    System.out.println("dc : " + dateCommitted);
                    break;    
                
            }

//            System.out.println("");
            line = bf.readLine();
        }
        
        StringBuilder messageBuilder = new StringBuilder();
        while( line != null ) {
            
            messageBuilder.append( line ).append("\n");
            line = bf.readLine();
        }
        
        message = messageBuilder.toString();
//        System.out.println(message);
        
//        System.out.println("-------------------------------------------------------");

    }   

    @Override
    public String toString() {
    
        StringBuilder sb = new StringBuilder( "name : " + getName() );
        sb.append("tree : ").append(tree.getName());
        parents.stream().forEach((parent) -> {
            sb.append("parent : ").append(parent.getName());
        });
        sb.append("authorName : ").append(authorName);
        sb.append("authorMail : ").append(authorMail);
        sb.append("dateWritten : ").append(dateWritten);
        sb.append("committerName : ").append(committerName);
        sb.append("committerMail : ").append(committerMail);
        sb.append("dateCommitted : ").append(dateCommitted);
        sb.append("message : ").append(message);
        
        return sb.toString();
    
    }

}