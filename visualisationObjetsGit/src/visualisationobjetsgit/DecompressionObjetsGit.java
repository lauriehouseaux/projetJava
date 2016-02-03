/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualisationobjetsgit;
import java.io.*;
/**
 *
 * @author Laurie
 */
public class DecompressionObjetsGit {
    



	public static void main(String[] args){
		FileInputStream fis;
		int byteLu;
		try{
			//creation d'un flux d'entrée ayant pour source un fichier nommé 			
			//source,cette instanciation peut lever une exception de type 				
			//FileNotFound
			fis=new FileInputStream("C:\\Users\\Laurie\\Desktop\\essaiGit\\.git\\objects\\dc\\106e69bee157bb70ba5cb1f6b2933550ce6199");
			//lecture des données
			try{
				long startChrono=System.currentTimeMillis();
				System.out.println("debut lecture");
				while((byteLu=fis.read())!=-1){
                                    System.out.print(byteLu);
                                }
                                    
				System.out.println("fin lecture");
				System.out.println("durée="+(System.currentTimeMillis()-startChrono));
			}
			finally{	
				//fermeture du flux
				fis.close();
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


