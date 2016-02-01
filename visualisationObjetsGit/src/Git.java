
import com.sun.corba.se.spi.activation.Repository;
import com.sun.corba.se.spi.ior.ObjectId;
import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author COT
 */
public class Git {
    
    Repository existingRepo = new FileRepositoryBuilder()
    .setGitDir(new File("my_repo/.git"))
    .build();
    
    // acceder a l'objet pointe par une reference
    ObjectId masterTip = master.getObjectId();


    // Charger le contenu brut d'un objet
    ObjectLoader loader = repo.open(masterTip);
    loader.copyTo(System.out);

}
