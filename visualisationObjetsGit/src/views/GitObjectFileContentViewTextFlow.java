package views;

import java.util.Observable;
import java.util.Observer;
import javafx.scene.text.TextFlow;
import model.Git;

public class GitObjectFileContentViewTextFlow extends TextFlow implements Observer{
    
    private Git model;
    
    public GitObjectFileContentViewTextFlow( Git model ){
        
        super();
    
        model.addObserver(this);
        
        this.model = model;
    }

    @Override
    public void update(Observable o, Object arg) {
        
        if( model.getSelectObject() == null ) {
//            setText( "selectionnez un objet dans la liste sur la gauche." );
        }
        else {
//            setText( model.getSelectObject().toString() );
        }
    }

}