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

    public String getMessage()
    {
        return mMessage;
    }

    public void setMessage( String mMessage )
    {
        this.mMessage = mMessage;
    }

    public int getRemainingSeconds()
    {
        return mRemainingSeconds;
    }

    public AttemptKind getKind()
    {
        return mKind;
    }

    public void tick()
    {
        mRemainingSeconds--;
    }
}
