/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualisationobjetsgit;

import java.io.FileReader;
import java.io.IOException;
import java.io.*;
/**
 *
 * @author Laurie
 */
public class TestFileReader {
    public static void main(String[] args){
		try{
			int i;
			//creation du flux
			FileReader fr=new FileReader("source");
			try{
				//lecture et affichage des données
				while((i=fr.read())!=-1){
					System.out.println((char)i);
				}
			}
			finally{
				fr.close();
			}
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
}
