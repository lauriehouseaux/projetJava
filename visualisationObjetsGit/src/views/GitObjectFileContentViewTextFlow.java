package views;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Hyperlink;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import model.Git;
import model.GitObject;
import model.GitObjectProperty;

public class GitObjectFileContentViewTextFlow extends TextFlow implements Observer{
    
    private Git model;
    
    public GitObjectFileContentViewTextFlow( Git model ){
        
        super();
    
        model.addObserver(this);
        
        this.model = model;
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
                                getChildren().add( new Hyperlink( ((GitObject)property.value).getName() ) );
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