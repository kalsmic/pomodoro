package pomodoro.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
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
    private Timeline mTimeline;

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
        setTimerText( mCurrentAttempt.getRemainingSeconds() );
        mTimeline = new Timeline();
        mTimeline.setCycleCount( kind.getmTotalSeconds() );
        mTimeline.getKeyFrames().add(new KeyFrame(Duration.seconds( 1 ), e -> {
            mCurrentAttempt.tick();
            setTimerText( mCurrentAttempt.getRemainingSeconds() );
        }) );

    }

    public void playTimer() {
        mTimeline.play();
    }

    public void pauseTimer(){
        mTimeline.pause();
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

    public void handleRestart( ActionEvent actionEvent )
    {
        prepareAttempt( AttemptKind.FOCUS );
        playTimer();
    }

}
