package views;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TreeItem;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import model.Git;
import model.GitObject;
import model.GitObjectProperty;

public class GitObjectFileContentViewTextFlow extends TextFlow implements Observer{
    
    private Git model;
    // on relie cette vue a la liste des objets pour changer la selection
    private GitObjectsFilesTreeView treeView;
    
    public GitObjectFileContentViewTextFlow( Git model, GitObjectsFilesTreeView treeView ){
        
        super();
    
        model.addObserver(this);
        
        this.model = model;
        this.treeView = treeView;
    }

    @Override
    public void update(Observable o, Object arg) {
        
        GitObject so = model.getSelectObject();
        
        getChildren().clear();
        
        if( so == null ) {
            getChildren().add( new Text("selectionnez un objet dans la liste sur la gauche.") );
        }
        else {
            try {
                for (GitObjectProperty property : so.getProperties()) {
                    getChildren().add( new Text( property.name + " : " ) );
                    switch(property.type) {
                        case STRING:
                            getChildren().add( new Text( (String)property.value ) );
                            break;
                            
                        case OBJECT_REF:
                            if( property.value == null ) {
                                getChildren().add( new Text( "null" ) );
                            }
                            else {
                                Hyperlink link = new Hyperlink( ((GitObject)property.value).getName() ); 
                                link.setOnAction((ActionEvent e) -> {
                                    
                                    treeView.selectByGitObject( (GitObject)property.value );
                                    
                                });
                                getChildren().add( link );
                            }
                            break;
                    }
                    getChildren().add( new Text( System.getProperty("line.separator") ) );
                }
            } catch (IOException ex) {
                getChildren().add( new Text(ex.getMessage()) );
            }
        }
    }

}