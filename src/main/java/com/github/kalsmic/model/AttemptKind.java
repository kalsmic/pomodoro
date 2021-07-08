package com.github.kalsmic.model;

public enum AttemptKind
{
    FOCUS(3, "Focus time"),
    BREAK(3*60, "Break time");

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
