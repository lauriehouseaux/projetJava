/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualisationobjetsgit;

import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

/**
 *
 * @author freeze
 */
public class VisualisationObjetsGit extends Application {
   
    public String open(Stage stage) {
        
        DirectoryChooser dc = new DirectoryChooser();
        
//        dc.setInitialDirectory(new File("D:\\Programmation\\Java"));
        
        File gitRepository = dc.showDialog(stage);
        File gitDirectory = new File(gitRepository, ".git");
        
        return gitDirectory.getAbsolutePath();


//        File gitObjectsDirectory = new File(new File(gitRepository, ".git"), "objects");
//        File[] gitObjects = gitObjectsDirectory.listFiles();

//        System.out.println(".git/objects : ");
//        for (File gitObject : gitObjects) {
//            System.out.println("\t" + gitObject.getName());
//        }
        
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Visualisation objets git");
        
        // Les elements de la fenetre principale seront disposes
        // en haut, gauche, droite, bas et centre
        BorderPane root = new BorderPane();
        
        // fenetre principale de taille fixe 1280 x 720p
        Scene scene = new Scene(root, 1280, 720);

        // barre de menu
        MenuBar menuBar = new MenuBar();
        
        // ------------------------------------------------------------
        // ---------------------- menu "fichier" ----------------------
            Menu menuFile = new Menu("Fichier");
            menuBar.getMenus().add(menuFile);

            // element "ouvrir" dans le menu "fichier"
            MenuItem menuFileOpen = new MenuItem("ouvrir");

            menuFileOpen.setOnAction( (ActionEvent t) -> {
                System.out.println(open(primaryStage));
            } );

            menuFile.getItems().add(menuFileOpen);
        // ---------------------- menu "fichier" ----------------------
        // ------------------------------------------------------------

            
        // ajout de la barre de menu dans la fenetre principale
        root.setTop(menuBar);
        

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(30, 30, 30, 30));
        grid.setVgap(5);
        grid.setHgap(5);

        TextField searchField = new TextField();
        searchField.setPromptText("Recherche");
        GridPane.setConstraints(searchField, 0, 0);
        grid.getChildren().add(searchField);
        
        Button searchButton = new Button("Recherche");
        GridPane.setConstraints(searchButton, 1, 0);
        grid.getChildren().add(searchButton);
        
        root.setCenter(grid);
        
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
