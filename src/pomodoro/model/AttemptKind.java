package pomodoro.model;

public enum AttemptKind
{
    FOCUS(25*60, "Focus time"),
    BREAK(25*60, "Break time");

    private int mTotalSeconds;
    private String mDisplayName;

    AttemptKind( int mTotalSeconds, String mdisplayName )
    {
        this.mTotalSeconds = mTotalSeconds;
        this.mDisplayName = mdisplayName;
    }

    public int getmTotalSeconds(){
        return mTotalSeconds;
    }

    public String getDisplayName()
    {
        return mDisplayName;
    }
}
