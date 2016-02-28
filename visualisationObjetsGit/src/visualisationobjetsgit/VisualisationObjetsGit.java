package visualisationobjetsgit;

import exceptions.NotGitRepositoryException;
import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import views.GitObjectsFilesTreeView;

/**
 *
 * @author Jarretier Adrien "jarretier.adrien@gmail.com"
 */
public class VisualisationObjetsGit extends Application {
   
    private GitObjectsFilesTreeView objectsFilesList;

    @Override
    public void init() {
        
        objectsFilesList = new GitObjectsFilesTreeView();
        
    }
    
    /**
     * ouvre une fenetre de selection de dossier,
     * le dossier doit etre un depot git valide
     * 
     * @param stage conteneur parent a cette fenetre de selection de dossier
     * 
     * @return - objet "File" representant le dossier ".git" <br>
     *         - ou null si la selection a ete annulee
     * 
     * @throws exceptions.NotGitRepositoryException 
     */
    public File openGitRepository(Stage stage) throws NotGitRepositoryException {
        
        DirectoryChooser dc = new DirectoryChooser();
        
        dc.setInitialDirectory(new File(System.getProperty("user.dir")));
        
        File gitRepository = dc.showDialog(stage);
        
        // DirectoryChooser.showDialog renvoie null en cas d'annulation
        if(gitRepository == null) {
            return null;
        }
        else { 
            File gitDirectory = new File(gitRepository, ".git");

            // leve une exception si le dossier ".git" n'existe pas
            // autrement dit : si le dossier selectionne n'est pas un depot git
            if(!gitDirectory.exists()) {

                throw new NotGitRepositoryException("Ce n'est pas un depot git valide !");

            }

            return gitDirectory;
        }
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Visualisation objets git");
        
        // Les elements de la fenetre principale seront disposes
        // en haut, gauche, droite, bas et centre
        BorderPane root = new BorderPane();
        
        // fenetre principale de taille fixe 1280 x 720p
        Scene scene = new Scene(root, 1280, 720);
        
        
        
        // -----------------------------------------------------------
        // ---------------------- barre de menu ----------------------

            // barre de menu
            MenuBar menuBar = new MenuBar();
        
            Menu menuFile = new Menu("Fichier");
            menuBar.getMenus().add(menuFile);

            // element "ouvrir" dans le menu "fichier"
            MenuItem menuFileOpen = new MenuItem("ouvrir");
            
            menuFileOpen.setOnAction( (ActionEvent t) -> {
               
                boolean validGitRepo; 
                do {
                    try {
                        File gitDir = openGitRepository(primaryStage);

                        // si openGitRepository renvoie null on ne fait aucun traitement
                        // ( la selection de dossier a ete annulee )
                        if( gitDir != null ) {
                            objectsFilesList.addListObjectsInTreeView( gitDir );
                        }

                        validGitRepo = true;
                    }
                    catch(NotGitRepositoryException e) {

                        Alert alert = new Alert(AlertType.ERROR, e.getMessage());
                        alert.showAndWait();
                        validGitRepo = false;

                    }
                }while( !validGitRepo );
                
            } );

            menuFile.getItems().add(menuFileOpen);
            
            // ajout de la barre de menu dans la fenetre principale
            root.setTop(menuBar);
            
        // ---------------------- barre de menu ----------------------
        // -----------------------------------------------------------
        
            
            
        // ------------------------------------------------------------
        // ----------------- tree View Liste fichiers -----------------
            
            root.setLeft(objectsFilesList);
        
        // ----------------- tree View Liste fichiers -----------------
        // ------------------------------------------------------------

            
            
// code de la barre de recherche * sera réutilisé plus tard *     
//        GridPane grid = new GridPane();
//        grid.setPadding(new Insets(30, 30, 30, 30));
//        grid.setVgap(5);
//        grid.setHgap(5);
//
//        TextField searchField = new TextField();
//        searchField.setPromptText("Recherche");
//        GridPane.setConstraints(searchField, 0, 0);
//        grid.getChildren().add(searchField);
//        
//        Button searchButton = new Button("Recherche");
//        GridPane.setConstraints(searchButton, 1, 0);
//        grid.getChildren().add(searchButton);
//        
//        root.setCenter(grid);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
