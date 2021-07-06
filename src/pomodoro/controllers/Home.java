package pomodoro.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import pomodoro.model.Attempt;
import pomodoro.model.AttemptKind;

public class Home
{
    @FXML
    private VBox container;

    @FXML
    private Label title;

    private Attempt mCurrentAttempt;
    private StringProperty mTimerText;

    public Home()
    {
        mTimerText = new SimpleStringProperty();
        setTimerText( 0 );
    }

    public String getTimerText()
    {
        return mTimerText.get();
    }

    public StringProperty timerTextProperty()
    {
        return mTimerText;
    }

    public void setTimerText( String mTimerText )
    {
        this.mTimerText.set( mTimerText );
    }

    public void setTimerText(int remainingSeconds){
        int minutes = remainingSeconds / 60;
        int seconds = remainingSeconds % 60;
        setTimerText( String.format( "%02d:%02d",minutes,seconds ) );
    }
    private void prepareAttempt( AttemptKind kind )
    {
        mCurrentAttempt = new Attempt( kind, "" );
        addAttemptStyle( kind );
        title.setText( kind.getDisplayName() );
        setTimerText( mCurrentAttempt.getmRemainingSeconds() );

    }

    private void addAttemptStyle( AttemptKind kind )
    {
        clearAttemptStyles();
        container.getStyleClass().add( kind.toString().toLowerCase() );
    }

    private void clearAttemptStyles()
    {
        for ( AttemptKind kind : AttemptKind.values() )
        {
            container.getStyleClass().remove( kind.toString().toLowerCase() );
        }
    }
}
