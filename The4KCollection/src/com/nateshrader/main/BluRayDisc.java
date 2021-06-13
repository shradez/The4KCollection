package com.nateshrader.main;

import java.math.BigDecimal;

public class BluRayDisc {

    private int uniqueID;
    private String title;
    private int releaseYear;
    private String mPAARating;
    private int runtimeInMin;
    private String directorNameFirst;
    private String directorNameLast;
    private BigDecimal iMDBScore;
    private boolean nateWatched;

    public BluRayDisc (int uniqueID, String title, int releaseYear, String mPAARating, int runtimeInMin, String directorNameFirst, String directorNameLast, BigDecimal iMDBScore, boolean nateWatched){
        this.uniqueID = uniqueID;
        this.title = title;
        this.releaseYear = releaseYear;
        this.mPAARating = mPAARating;
        this.runtimeInMin = runtimeInMin;
        this.directorNameFirst = directorNameFirst;
        this.directorNameLast = directorNameLast;
        this.iMDBScore = iMDBScore;
        this.nateWatched = nateWatched;
    }

    public int getUniqueID() {
        return uniqueID;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getmPAARating() {
        return mPAARating;
    }

    public int getRuntimeInMin() {
        return runtimeInMin;
    }

    public String getDirectorNameFirst() {
        return directorNameFirst;
    }

    public String getDirectorNameLast() {return directorNameLast;}

    public BigDecimal getiMDBScore() {
        return iMDBScore;
    }

    public boolean hasNateWatched() {
        return nateWatched;
    }

    // Derived attribute for director full name
    public String getDirectorFullName(){
        return directorNameFirst + directorNameLast;
    }

    // toString
    public String toString() {
        return uniqueID + ". " + title + " | " + releaseYear + " | " + mPAARating + " | " + runtimeInMin + " minutes" + " | " + "IMDB Score: " + iMDBScore;
    }




}
