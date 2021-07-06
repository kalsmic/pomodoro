package pomodoro.model;

public class Attempt
{
    private String mMessage;
    private int mRemainingSeconds;
    private AttemptKind mKind;

    public Attempt(  AttemptKind mKind, String mMessage )
    {
        this.mMessage = mMessage;
        this.mKind = mKind;
        this.mRemainingSeconds = mKind.getmTotalSeconds();
    }

    public String getmMessage()
    {
        return mMessage;
    }

    public void setmMessage( String mMessage )
    {
        this.mMessage = mMessage;
    }

    public int getmRemainingSeconds()
    {
        return mRemainingSeconds;
    }

    public AttemptKind getmKind()
    {
        return mKind;
    }
}
