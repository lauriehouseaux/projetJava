/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualisationobjetsgit;
import java.io.*;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
/**
 *
 * @author Laurie
 */
public class DecompressionObjetsGit {
    



	public static void main(String[] args) throws DataFormatException{
		FileInputStream fis;
		int octetLu;
		try{
			//creation d'un flux d'entrée ayant pour source un fichier nommé 			
			//source,cette instanciation peut lever une exception de type 				
			fis=new FileInputStream("C:\\Users\\Laurie\\Desktop\\essaiGit\\.git\\objects\\dc\\106e69bee157bb70ba5cb1f6b2933550ce6199");
                        // initialisation d'un tableau d'octet
                        byte[] b = new byte[30];
                        // placement de chaque octet lu dans le tableau
                        octetLu = fis.read(b);
                        
                        //System.out.println(octetLu);
                    
			//lecture des données
			Inflater decompresser = new Inflater();
                        // decompression du fichier par rapport a la taille de notre tableau
                        decompresser.setInput(b,0,octetLu);
                        // initialisation d'un tableau d'octet
                        byte[] res = new byte[100];
                        //decompression du fichier + recuperation de la taille du tableau 
                        int taille = decompresser.inflate(res);
                        decompresser.end();
                        
                        // affichage du contenu du tableau
                        for (int i = 0; i < taille ; i++) {
                        System.out.print((char)res[i]);
                    }
                        
                        
		}
		catch(FileNotFoundException ef){
			System.out.println("fichier introuvable");
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
}


